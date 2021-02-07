<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html> -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>Choose Items</TITLE>
	</HEAD>
	<BODY BGCOLOR="#FDF5E6">
		<H1 ALIGN="CENTER">Online shopping</H1>
		<FORM ACTION = "collector" METHOD = "POST">
		<TABLE ALIGN="center" WIDTH="100%" cellspacing='2' cellpadding='2' border=3>
			<TR><TH align='left'><B>Customer's Name</B>&nbsp;<TH align='left'>
			<INPUT TYPE="TEXT" NAME = "name" size=40>
			<TR><TD>
			<H3>Cricket Kit</H3>
			<TR><TD>Bat     </TD><TD><INPUT TYPE="CHECKBOX" NAME="items" VALUE="Bat"></TD>
			<TR><TD>Ball    </TD><TD><INPUT TYPE="CHECKBOX" NAME="items" VALUE="Ball"></TD>
			<TR><TD>Pads    </TD><TD><INPUT TYPE="CHECKBOX" NAME="items" VALUE="Pads"></TD>
			<TR><TD>Gloves  </TD><TD><INPUT TYPE="CHECKBOX" NAME="items" VALUE="Gloves"></TD>
			<TR><TD>W.Gloves</TD><TD><INPUT TYPE="CHECKBOX" NAME="items" VALUE="W.Gloves"></TD>
			<TR><TD>Helmet  </TD><TD><INPUT TYPE="CHECKBOX" NAME="items" VALUE="Helmet"></TD>
		</TABLE>
		<BR><BR>
		<CENTER>
			<INPUT TYPE="RESET" VALUE = "RESET">
			<INPUT TYPE="SUBMIT" NAME="submit" VALUE = "Go To Cart">
		</CENTER>
		</FORM>
	</BODY>
</HTML>