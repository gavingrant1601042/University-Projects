using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;


namespace EBANKING
{
    public partial class Accountbal : System.Web.UI.Page
    {
        private account Account;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Email"] == null)
            {
                ClientScript.RegisterStartupScript(Page.GetType(), "validation", "<script language='javascript'>alert('Please Login first')</script>");

            }
            else
            {
                Account = this.GetAccount();
                lblbalance.Text = Account.ACCOUNT_AMOUNT.ToString();
            }

        }

        private account GetAccount()
        {
            DataView itemtable = (DataView)SqlDataSource1.Select(DataSourceSelectArguments.Empty);
            itemtable.RowFilter = "EMAIL = '" + Session["EMAIL"] + "'";
            DataRowView row = (DataRowView)itemtable[0];
            account a = new account
            {
                ACCOUNT_NUMBER = (int)row["ACCOUNT_NUMBER"],
                ACCOUNT_AMOUNT = (Decimal)row["ACCOUNT_AMOUNT"]

            };
            return a;

        }

        private class account
        {
            public int ACCOUNT_NUMBER { get; set; }
            public Decimal ACCOUNT_AMOUNT { get; set; }


        }
    }
}