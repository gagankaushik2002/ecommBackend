<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
		<div class="container">
			<table class="table">
				<tr>
					<td colspan="5">
						<center>
							<h3>Receipt</h3>
						</center>
					</td>
				</tr>
				<tr>
					<td>Order ID</td>
					<td>ORD00${orderDetail.orderId}</td>
					<td></td>
					<td>Order Date</td>
					<td>${orderDetail.orderDate}</td>
				</tr>
				
				<tr bgcolor="lightblue">
					<td>SL #</td>
					<td>Product Name</td>
					<td>Quantity</td>
					<td>Price</td>
					<td>Total Price</td>
				</tr>
				<c:if test="${empty cartItems}">
					<tr bglcolor="pink"><td colspan="5"><center><h4>!!!Your Cart is Empty!!!</h4></center></td></tr>
				</c:if>
				
				<c:if test="${not empty cartItems}">
					<c:set var="cartCount" value="0" scope="page" />
					<c:forEach items="${cartItems}" var="cartItem">
						<tr>
							<td><c:out value="${cartCount + 1}" /></td>
							<td>${cartItem.productName}</td>
							<td>
								<input id="quantity" name="quantity" type="text" value="${cartItem.quantity}"/>
							</td>
							<td>${cartItem.price}</td>
							<td>${cartItem.quantity*cartItem.price} </td>
							
						</tr>
						<c:set var="cartCount" value="${cartCount + 1}" scope="page"/>
					</c:forEach>
				</c:if>
				
				<tr bgcolor="orange">
					<td colspan="4">Total Purchase Amount</td>
					<td colspan="2">INR.${totalPurchaseAmount}</td>
				</tr>
				
				<tr bgcolor="cyan">
					<td colspan="5">
						<center>Thanks For Shopping Here......Hope to see you again</center>
					</td>
				</tr>
			</table>
		</div>
		</br></br></br>

	</body>
</html>