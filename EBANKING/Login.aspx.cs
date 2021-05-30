using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Data;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;

namespace EBANKING
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnsignin_Click(object sender, EventArgs e)
        {
            using (SqlConnection connection = new SqlConnection(ConfigurationManager.ConnectionStrings["myConnection"].ConnectionString))
            {
                Session["EMAIL"] = txtemail.Text;
                Session["HOLDERPWD"] = txtpassword.Text;
                connection.Open();
                SqlCommand com= new SqlCommand("select * from ACCOUNTHOLDERS where EMAIL =@EMAIL AND HOLDERPWD = @PASSWORD", connection);
                com.Parameters.AddWithValue("@EMAIL", txtemail.Text);
                com.Parameters.AddWithValue("@PASSWORD", txtpassword.Text);

                SqlDataAdapter da = new SqlDataAdapter(com);
                DataTable dt = new DataTable();
                da.Fill(dt);
                if (dt.Rows.Count > 0)
                {
                    Response.Redirect("MyAccount.aspx");
                }
                else
                {
                    ClientScript.RegisterStartupScript(Page.GetType(), "validation", "<script language='javascript'>alert('Invalid Username and Password')</script>");
                }

            }
        }
    }
}