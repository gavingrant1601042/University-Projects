<%@ Page Title="" Language="C#" MasterPageFile="~/start.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="EBANKING.Register" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
    .Regform {
            background-color: white;
            text-align: center;
            background-size: 60%;
            background-size:auto;
            overflow:auto;
    }
    .Login{
        text-align:center;
        border: thin solid #008000; 
        color: #CC6600; 
        font-size: large; 
        text-decoration: blink;
        text-transform: uppercase;
        
    }
    .Textbox{
            overflow:auto;
            height : 20px;
            border-radius: 5px;
            width: 200px;
        }
    .Button{
            color: #fff !important;
            background-color:red;
            padding: 20px;
            border-radius: 50px;
            display: inline-block;
            transition: all 0.4s ease 0s;
            cursor: pointer;
			width: 200px;
			height: 12px;
            
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <div class="Regform">
     
     <p style="font-size: xx-large; font-weight: bold; text-decoration: underline"> Please Fill Out The Form to Register </p></div>
        <center>
            <asp:Label ID="lblfname" runat="server" Text="First Name" CssClass="Form"></asp:Label>
            <asp:TextBox ID="txtfname" runat="server" Placeholder="John" CssClass="Textbox"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvfname" runat="server" ControlToValidate="txtfname" ErrorMessage="Please Enter your First Name" Display="Dynamic" ForeColor="Red"></asp:RequiredFieldValidator>
 &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
            <asp:Label ID="lbllname" runat="server" Text="Last Name" CssClass="Form"></asp:Label>
            <asp:TextBox ID="txtlname"  Placeholder="Doe" runat="server" CssClass="Textbox"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvlname" runat="server" ControlToValidate="txtlname" ErrorMessage="Please Enter your Last Name" Display="Dynamic" ForeColor="Red" ></asp:RequiredFieldValidator><br />
            <br />


            <asp:Label ID="lblemail" runat="server" Text="Email Address" CssClass="Form"></asp:Label>
            <asp:TextBox ID="txtemail" Placeholder="Examale@email.com" runat="server" CssClass="Textbox"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvemail" runat="server" ControlToValidate="txtemail" ErrorMessage="Please Enter a Valid Email Address" ForeColor="Red" Display="Dynamic" ></asp:RequiredFieldValidator><br />
            <asp:RegularExpressionValidator ID="revemail" runat="server" ErrorMessage="Please Enter a Valid Email Adress" ControlToValidate="txtemail" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" ForeColor="Red" Display="Dynamic"></asp:RegularExpressionValidator><br />


            <asp:Label ID="lblpassword" runat="server" Text="Password" CssClass="Form"></asp:Label>
            <asp:TextBox ID="txtpassword" Placeholder="Your own Password" runat="server" TextMode="Password" CssClass="Textbox"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvpassword" runat="server" ControlToValidate="txtpassword" ErrorMessage="Please Enter a password" ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
            &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp

            <asp:Label ID="lblconpassword" runat="server" Text="Confirm Password" CssClass="Form"></asp:Label>
            <asp:TextBox ID="txtconpassword" Placeholder="Rewrite above password" runat="server" TextMode="Password" CssClass="Textbox"></asp:TextBox>
            <asp:CompareValidator ID="cvpassword" runat="server" ControlToValidate="txtconpassword" ValueToCompare="txtpassword" ErrorMessage="Passwords Do not Match" ControlToCompare="txtpassword" Operator="DataTypeCheck" ForeColor="Red" Display="Dynamic"></asp:CompareValidator><br />
            <br />

            <asp:Label ID="lblaccnum" runat="server" Text="Account Number" CssClass="Form"></asp:Label>
            <asp:TextBox ID="txtaccnum" Placeholder="xxxx-xxx-xxxx" runat="server" CssClass="Textbox"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvaccnum" runat="server" ControlToValidate="txtaccnum" ErrorMessage="Please Enter Your Account Number" ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator><br />

            <br />
            <br />
    <asp:Button ID="btnRegister" runat="server" Text="Register" OnClick="btnRegister_Click" CssClass="Button" />
      
    <div >
       <h2 > Already have an Account sign in Here</h2>
        <a target="_parent" href="Login.aspx">Sign In</a>
    </div>
            </center>
</asp:Content>

