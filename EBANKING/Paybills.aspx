<%@ Page Title="Paybills" Language="C#" MasterPageFile="~/start.Master" AutoEventWireup="true" CodeBehind="Paybills.aspx.cs" Inherits="EBANKING.Paybills" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
        .navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: cornflowerblue;
            float: left;
        }
        navbar a:hover:not(.active){

			background-color:#EFF109;
		}
		navbar a:hover:active{

			background-color:#2F9F08;
		}
        .navbarl{
            height:30px;
            border-bottom:3px solid black;
        }
        
        .navbarl a{
            color: white;
			padding: 12px 14px;
            text-decoration:none;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
     <ul class="navbar">
        <li class="navbarl"><a href="MyAccount.aspx" target="_parent">View My Account</a></li>
        <li class="navbarl"><a href="Paybills.aspx" target="_parent">Pay your Bills </a></li>
        <li class="navbarl"><a href="Accountbal.aspx" target="_parent">View Account Balance</a></li>
    </ul>
</asp:Content>
