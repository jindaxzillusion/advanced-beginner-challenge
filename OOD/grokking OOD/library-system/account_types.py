from abc import ABC
from datetime import datetime

from .constants import *
from .models import *

class Account(ABC):
    def __init__(self, id, password, person, status=AccountStatus.Active):
        self.__id = id
        self.__password = password
        self.__status = status
        self.__person = person

    def reset_password(self):
        None


class Librarian(Account):
    def __init__(self, id, password, person, status=AccountStatus.Active):
        super().__init__(id, password, person, status)

    def add_book_item(self, book_item):
        None

    def block_member(self, member):
        None

    def un_block_member(self, member):
        None


class Member(Account):
    def __init__(self, id, password, person, status=AccountStatus.Active):
        super().__init__(id, password, person, status)
        self.__date_of_membership = datetime.date.today()
        self.__total_books_checked_out = 0

    def get_total_books_checked_out(self):
        return self.__total_books_checked_out

    def reserve_book_item(self, book_item):
        None

    def increment_total_books_checked_out(self):
        None

    def checkout_book_item(self, book_item):
        if self.get_total_books_checked_out() >= Constrants.MAX_BOOKS_ISSUED_TO_A_USER:
            print("The user has already checked-out max number of books")
            return False
        book_reservation = BookReservation.fetch_reservation_details(
            book_item.get_barcode())
        # book item has a pending reservation from another user
        if book_reservation != None and book_reservation.get_member_id() != self.get_id():
            print("self book is reserved by another member")
            return False
        # book item has a pending reservation from the give number, update it
        elif book_reservation != None:
            book_reservation.update_status(ReservationStatus.COMPLETED)

        if not book_item.checkout(self.get_id()):
            return False
        self.increment_total_books_checked_out()
        return True

    def check_for_fine(self, book_item_barcode):
        book_lending = bookLending.fetch_lending_details(book_item_barcode)
        due_date = book_lending.get_due_date()
        today = datetime.date.today()
        # check if the book has been returned within the due date
        if today > due_date:
            diff = today - due_date
            diff_days = diff.days
            Fine.collect_fine(self.get_member_id(), diff_days)

    def return_book_item(self, book_item):
        self.check_for_fine(book_item.get_barcode())
        book_reservation = BookReservation.fetch_reservation_details(
            book_item.get_barcode())
        if book_reservation != None:
            book_item.update_book_item_status(BookStatus.RESERVED)
            book_reservation.send_book_available_notification()
        book_item.update_book_item_status(BookStatus.AVAILABLE)

    def renew_book_item(self, book_item):
        self.check_for_fine(book_item.get_barcode())
        book_reservation = BookReservation.fetch_reservation_details(
            book_item.get_barcode())
        # check if self book item has a pending reservation from another member
        if book_reservation != None and book_reservation.get_member_id() != self.get_member_id():
            print("self book is reserved by another member")
            self.decrement_total_books_checkedout()
            book_item.update_book_item_status(BookStatus.RESERVED)
            book_reservation.send_book_available_notification()
            return False
        elif book_reservation != None:
            book_reservation.update_status(ReservatioStatus.COMPLETED)
        BookLending.lend_book(book_item.get_barcode(), self.get_member_id())
        book_item.update_due_date(
            datetime.datetime.now().addDays(Constrants().MAX_LENDING_DAYS))
        return True