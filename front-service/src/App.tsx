import React from "react";
import styled, { createGlobalStyle } from "styled-components"
import {BrowserRouter as Router} from 'react-router-dom';
import Main from "./components/Main";
import UserRouteController from "./components/user/userRoute/UserRouteController";
import BiddingList from "./components/bidding/biddingList/BiddingList";

const GlobalStyle = createGlobalStyle`
    body{
        background: #e9ecef;
        display: flex;
        justify-content: flex-end;
    }
`
const App = () => (
    <Router>
        <GlobalStyle/>
        <BiddingList/>
        {/* <Main/> */}
    </Router>
);

export default App;