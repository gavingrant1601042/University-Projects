<%@ Page Title="" Language="C#" MasterPageFile="~/start.Master" AutoEventWireup="true" CodeBehind="MyAccount.aspx.cs" Inherits="EBANKING.MyAccount" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
        .navbar {
            list-style-type:none;
            margin: 0;
			padding: 0;
			overflow: hidden;
            background-color:cornflowerblue;
            float:left;

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
        #info{
            
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

    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <ul class="navbar">
        <li class="navbarl"><a href="MyAccount.aspx" target="_parent">View My Account</a></li>
        <li class="navbarl"><a href="Paybills.aspx" target="_parent">Pay your Bills </a></li>
        <li class="navbarl"><a href="Accountbal.aspx" target="_parent">View Account Balance</a></li>
    </ul>
    <div id="info" align="center">
        <p >Welcome &nbsp <asp:Label ID="lblusername" runat="server" Text=""> &nbsp </asp:Label>To Your Account Profile</p>
        <table cellpadding="5" cellspacing="3" border="1" height="200px" width="700px">
            <tr>
                <td colspan="6">
                    <asp:Label ID="lblaccnum" runat="server" Text="Account Number"></asp:Label>
                    <asp:TextBox ID="txtaccnum" runat="server" Height="24px" ReadOnly="True" Width="454px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <asp:Label ID="lblfname" runat="server" Text="First Name"></asp:Label>
                    <asp:TextBox ID="txtfname" runat="server" Height="24px" ReadOnly="True" Width="222px"></asp:TextBox>
                </td>
                 <td colspan="3">
                    <asp:Label ID="lbllname" runat="server" Text="Last Name"></asp:Label>
                     <asp:TextBox ID="txtlname" runat="server" Height="24px" ReadOnly="True" Width="216px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <asp:Label ID="lblemail" runat="server" Text="My Email Address"></asp:Label>
                    <asp:TextBox ID="txtemail" runat="server" Height="24px" ReadOnly="True" TextMode="MultiLine" Width="184px"></asp:TextBox>
                </td>
                 <td colspan="2">
                    <asp:Label ID="lblpassword" runat="server" Text="My Password"></asp:Label>
                     <asp:TextBox ID="txtpassword" runat="server" Height="24px" ReadOnly="True" Width="203px"></asp:TextBox>
                </td>
            </tr>
        </table>
        <asp:Button ID="btnlogout" runat="server" Text="Logout In" CssClass="Button" OnClick="btnlogout_Click" />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:myConnection %>" ProviderName="<%$ ConnectionStrings:myConnection.ProviderName %>" SelectCommand="SELECT [HOLDERID], [FIRSTNAME], [LASTNAME], [EMAIL], [HOLDERPWD], [ACCOUNT_NUMBER] FROM [ACCOUNTHOLDERS] ORDER BY [FIRSTNAME]"></asp:SqlDataSource>
    </div>
</asp:Content>
