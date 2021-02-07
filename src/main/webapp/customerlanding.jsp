<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href=".\css\Customer.css">
<script src=".\js\Customer.js"></script>
<title>Your Bank</title>
</head>
<body>
	<h2>Welcome to the Bank</h2>
	<nav>
		<a class="viewaccounts">View Accounts</a> 
		<a class="viewpendingtransfers">View Pending Transfers</a>
	</nav>
	<div class="table accounts">
		<div class="row headers accounts">
			<div class="column accounts sample">Account #</div>
			<div class="column accounts sample">Type</div>
			<div class="column accounts sample">Balance</div>
		</div>
		<div class="row sample current">
			<div class="sample number"></div>
			<div class="sample type"></div>
			<div class="sample balance"></div>
		</div>
		<div class="table sample history">
			<div class="row headers sample history">
				<div class="column history sample">Timestamp</div>
				<div class="column history sample">Description</div>
				<div class="column history sample">Amount</div>
				<div class="column history sample">Previous Balance</div>
			</div>
			<div class="row headers sample history">
				<div class="sample history timestamp"></div>
				<div class="sample history description"></div>
				<div class="sample history amount"></div>
				<div class="sample history previousbalance"></div>
			</div>
		</div>
	</div>
</body>
</html>