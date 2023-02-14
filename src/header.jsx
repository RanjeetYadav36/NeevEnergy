import { Card } from 'antd';
import './header.css';
import {NavLink} from "react-router-dom"

export const Header = ()=>{
return(
    // <Card>
    <div className="App-header">
   
    <img className="logo" src = "https://neevenergy.com/wp-content/uploads/2018/11/logo-for-site_380X165.png"></img>
    <div>
    <ul className = "headerList">
    <li> <NavLink to="/csv">Home</NavLink></li>
    <li> <NavLink to ="/file">About Us</NavLink></li>
    <li>Contact Us</li>
    </ul>
    
    </div>
    
         
      </div>
    //   </Card>
)

}