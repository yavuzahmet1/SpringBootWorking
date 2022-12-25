import React from "react";
import {Link} from "react-router-dom";

function Navbar() {
    let userId = 1;
    return(
        <div>
            <ul>
                <li><Link to='/'>Home</Link></li>
                <li><Link to = {"/users/"+userId}> User </Link></li>
            </ul>
        </div>
    )

}
export default Navbar;