using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace EBANKING
{
    
    public partial class MyAccount : System.Web.UI.Page
    {
        private Holders holders;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Email"] == null)
            {
                ClientScript.RegisterStartupScript(Page.GetType(), "validation", "<script language='javascript'>alert('Please Login first')</script>");

            }
            else
            {
                holders = this.GetHolders();
                txtaccnum.Text = holders.ACCOUNT_NUMBER.ToString();
                txtfname.Text = holders.FIRSTNAME;
                txtlname.Text = holders.LASTNAME;
                txtemail.Text = holders.EMAIL;
                txtpassword.Text = holders.HOLDERPWD;
                lblusername.Text = holders.FIRSTNAME;
            }
            

        }

        private Holders GetHolders()
        {
            DataView itemtable = (DataView)SqlDataSource1.Select(DataSourceSelectArguments.Empty);
            itemtable.RowFilter = "EMAIL = '" + Session["EMAIL"] + "'";
            DataRowView row = (DataRowView)itemtable[0];
            Holders o = new Holders
            {
                FIRSTNAME = row["FIRSTNAME"].ToString(),
                LASTNAME = row["LASTNAME"].ToString(),
                EMAIL = row["EMAIL"].ToString(),
                HOLDERPWD = row["HOLDERPWD"].ToString(),
                ACCOUNT_NUMBER = (int)row["ACCOUNT_NUMBER"]
            };
            return o;

        }

        private class Holders
        {
            public string FIRSTNAME { get; set; }
            public string LASTNAME { get; set; }
            public string EMAIL { get; set; }
            public string HOLDERPWD { get; set; }
            public int ACCOUNT_NUMBER { get; set; }

        }

        protected void btnlogout_Click(object sender, EventArgs e)
        {
            Session.Clear();
            Response.Redirect("Login.aspx");
        }
    }

    
}