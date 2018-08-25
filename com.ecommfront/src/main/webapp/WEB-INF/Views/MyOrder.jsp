<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
	
		<div class="container">
			<table class="table table-striped table-hover table-condensed">
				<tr class="success"><td colspan="5"><center>Your Order</center></td></tr>
				<tr>
					<th>SL #</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Total Price</th>
				</tr>
				<c:if test="${empty cartItems}">
					<tr><td colspan="5">Your Cart is Empty</td></tr>
				</c:if>
				
				<c:if test="${not empty cartItems}">
					<c:set var="cartCount" value="0" scope="page" />
					<c:forEach items="${cartItems}" var="cartItem">
						<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
							<tr>
								<td><c:out value="${cartCount + 1}" /></td>
								<td>${cartItem.productName}</td>
								<td>${cartItem.quantity}</td>
								<td>${cartItem.price}</td>
								<td>${cartItem.quantity*cartItem.price} </td>
							</tr>
						</form>
						<!-- <c:set var="cartCount" value="${cartCount + 1}" scope="page"/> -->
					</c:forEach>
				</c:if>
				<tr class="success">
					<td class="danger" colspan="4">Total Purchase Amount</td>
					<td class="danger" colspan="1">${totalPurchaseAmount}</td>
				</tr>
				<tr class="success">
					<!--  continueShopping is in CartAndCartItemController -->
					<td colspan="4"><a class="btn btn-success" href="<c:url value="/continueShopping"/>">Continue Shopping</a>
					<!--  payment is in OrderAndPaymentController -->
					<td><a class="btn btn-success" href="<c:url value="/payment"/>">Payment</a>
				</tr>
			</table>
		</div>
	</body>
</html>