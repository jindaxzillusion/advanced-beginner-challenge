# Enums, DataTypes, Constants: Here are the required enums, data types, and constants:
class PieceType:
    ROOK = "rook"
    KNIGHT = "knight"
    BISHOP = "bishop"
    QUEEN = "queen"
    KING = "king"
    PAWN = "pawn"

CHESS_BOARD_SIZE = 8

INITIAL_PIECE_SET_SINGLE = [
    (PieceType.ROOK, 0, 0),
    (PieceType.KNIGHT, 1, 0),
    (PieceType.BISHOP, 2, 0),
    (PieceType.QUEEN, 3, 0),
    (PieceType.KING, 4, 0),
    (PieceType.BISHOP, 5, 0),
    (PieceType.KNIGHT, 6, 0),
    (PieceType.ROOK, 7, 0),
    (PieceType.PAWN, 0, 1),
    (PieceType.PAWN, 1, 1),
    (PieceType.PAWN, 2, 1),
    (PieceType.PAWN, 3, 1),
    (PieceType.PAWN, 4, 1),
    (PieceType.PAWN, 5, 1),
    (PieceType.PAWN, 6, 1),
    (PieceType.PAWN, 7, 1)
]

# Board: To encapsulate a cell on the chess board:
from copy import deepcopy
from .pieces import Piece, PieceFactory
from .moves import ChessPosition, MoveCommand
from .constants import CHESS_BOARD_SIZE, INITIAL_PIECE_SET_SINGLE, PieceType

class ChessBoard:
    def __init__(self, size=CHESS_BOARD_SIZE):
        self.size = size
        self._pieces = []
        self._white_king_position = None
        self._black_king_position = None
        self._initialize_pieces(INITIAL_PIECE_SET_SINGLE)

    def _initialize_pieces(self, pieces_setup: list):
        for piece_tuple in pieces_setup:
            type = piece_tuple[0]
            x = piece_tuple[1]
            y = piece_tuple[2]
        
        piece_white = PieceFactory.create(type, ChessPosition(x, y), Piece.WHITE)
        if type == PieceType.KING:
            piece_white.set_board_handle(self)
        self._piece.append(piece_white)

        piece_black = PieceFactory.create(type, ChessPosition(self._size-x-1, self._size-y-1), Piece.BLACK)
        if type == PieceType.KING:
            piece_black.set_board_handle(self)
        self._piece.append(piece_black)