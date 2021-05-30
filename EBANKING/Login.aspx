<%@ Page Title="Login" Language="C#" MasterPageFile="~/start.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="EBANKING.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
         .Textbox{
            overflow:auto;
            height : 20px;
            border-radius: 5px;
        }
        .Button{
            color: #fff !important;
            background-color: red;
            padding: 20px;
            border-radius: 50px;
            display: inline-block;
            transition: all 0.4s ease 0s;
            cursor: pointer;
			width: 200px;
			height: 12px;
            
        }
        .heading{
            font-family: sans-serif;
            font-style:normal;
            text-align:center
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
     <h2 class="heading"><center>Login here</center></h2>
    <center><img src="Images/avatar.png" style="border-radius:50px" width="60px" height="60px"/></center>
    <div align ="center">
        <br />
            <asp:Label ID="lblemail" runat="server" Text="Email" Font-Bold="True" Font-Size="X-Large"></asp:Label><span style="color: #FF0000">*</span>
            <br />
            <asp:TextBox ID="txtemail" runat="server" CssClass="Textbox"></asp:TextBox> 
            <asp:RequiredFieldValidator ID="rfvemail" runat="server" ErrorMessage="Email is Required" ControlToValidate="txtemail" Display="Dynamic" ForeColor="Red"></asp:RequiredFieldValidator>
            <br /> <br />
            <asp:Label ID="Lblpassword" runat="server" Text="Password" Font-Bold="True" Font-Size="X-Large" ></asp:Label><span style="color: #FF0000">*</span>
            <br />
            <asp:TextBox ID="txtpassword" runat="server" Textmode="Password" CssClass="Textbox"></asp:TextBox>
            <asp:RequiredFieldValidator ID="efvpassword" runat="server" ErrorMessage="Password is required" ControlToValidate="txtpassword" Display="Dynamic" ForeColor="Red"></asp:RequiredFieldValidator><br /> 
            <br /><br />
            <asp:Button ID="btnsignin" runat="server" Text="Sign In" CssClass="Button" OnClick="btnsignin_Click"/>

    </div>
</asp:Content>