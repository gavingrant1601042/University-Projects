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
    public partial class Register : System.Web.UI.Page
    {
        SqlConnection con = new SqlConnection(@"Data Source=LAPTOP-1TTNHUIS\SQLEXPRESS; Initial Catalog=MGGD; Integrated Security=True");
        protected void Page_Load(object sender, EventArgs e)
        {
            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
            con.Open();
        }

        protected void btnRegister_Click(object sender, EventArgs e)
        {
            Session["EMAIL"] = txtemail.Text;
            Session["HOLDERPWD"] = txtpassword.Text;
            SqlCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "Insert into ACCOUNTHOLDERS values('" + txtfname.Text + "', '" + txtlname.Text + "', '" + txtemail.Text + "', '" + txtpassword.Text + "', '" + txtaccnum.Text + "')";
            cmd.ExecuteNonQuery();

            txtfname.Text = "";
            txtlname.Text = "";
            txtemail.Text = "";
            txtpassword.Text = "";
            txtaccnum.Text = "";

            ClientScript.RegisterStartupScript(Page.GetType(), "validation", "<script language='javascript'>alert('Registration Successful')</script>");


            Response.Redirect("MyAccount.aspx");
        }
    }
}