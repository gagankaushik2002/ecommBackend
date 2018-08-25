<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
		 <script type="text/javascript">
			function checkPayment()
			{
				var payMode = document.getElementsByName("paymentType");
				if (payMode[0].checked == false && payMode[1].checked == false) 
				{
					alert("you must select a payment mode");
					return false;
				}
				else
				{
					document.getElementById("submiIt").click();
				}

			 
	            
			}
			function checkPayMode()
			{
				
				var payMode = document.getElementsByName("paymentType");
				if (payMode[0].checked == true) 
				{
					document.getElementById("cardNo").disabled = false; 
					document.getElementById("cvv").disabled = false;
					document.getElementById("valid").disabled = false;
					
	            } 
				else if (payMode[1].checked == true) 
				{
					document.getElementById("cardNo").disabled = true; 
					document.getElementById("cvv").disabled = true;
					document.getElementById("valid").disabled = true;
					
	            } 
			}
		</script>
		
		<div class="container">
			<table class="table">
				<tr>
					<td colspan="6">
						<center>
							<h3>Your Order</h3>
						</center>
					</td>
				</tr>
				<tr bgcolor="orange">
					<td colspan="4">Total Purchase Amount</td>
					<td colspan="2">${totalPurchaseAmount}</td>
				</tr>
			</table>
		</div>
		</br></br></br>
		
		<form action="<c:url value="/paymentProcess/"/>" method="post">
			<div class="container">
				<table class="table" align="center">
					<tr>
						<td colspan="2">Payment Option</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="radio" name="paymentType" value="cc" onclick="checkPayMode();"/>Credit Card
							<input type="radio" name="paymentType" value="COD" onclick="checkPayMode();"/>Cash On Delivery
						</td>
					</tr>
					<tr>
						<td>Card No :</td>
						<td><input type="text" id="cardNo" name="cardNo"/> </td>
					</tr>
					<tr>
						<td>CVV :</td>
						<td><input type="text" id="cvv" name="cvv"/> </td>
					</tr>
					<tr>
						<td>Valid Upto :</td>
						<td><input type="text" id="valid" name="valid"/> </td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" onclick="checkPayment();"  value="Payment"/>
							<input id= "submiIt" type="submit"  style="visibility: hidden;"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="msg"></div>
		</form>
	</body>
</html>