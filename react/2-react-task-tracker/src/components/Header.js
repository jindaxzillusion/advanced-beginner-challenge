// not required
// import React from 'react'
import PropTypes from 'prop-types'
import Button from './Button'
import { useLocation } from 'react-router-dom'

const Header = ({title, onAdd, showAdd}) => {
  const location = useLocation()
  // const onClick = () => {
  //   console.log('Click');
  // }
  // inline style use {{}}
  return (
    <header className='header'>
        <h1 style={headingStyle}>{title}</h1>
        {location.pathname === "/" &&<Button color={showAdd ? 'red' : 'green'} text={showAdd ? 'Close' : 'Add'} onClick={onAdd}/>}
        {/* <Button color='blue' text='Hello 1'/>
        <Button color='red' text='Hello 3'/> */}
    </header>
  )
} 
// set default props
Header.defaultProps = {
    title: 'Task Tracker',
}

Header.propTypes = {
    title: PropTypes.string.isRequired,
}

// CSS in JS
const headingStyle = {
    color: 'red', 
    backgroundColor: 'black'
}

export default Header