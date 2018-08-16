<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
		
		<table class="table">
			<tr bgcolor="pink"><td colspan="6"><center>Shopping Cart</center></td></tr>
			<tr>
				<td>SL #</td>
				<td>Product Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>Total Price</td>
				<td>Operation</td>
			</tr>
			<c:if test="${empty cartItems}">
				<tr><td colspan="6">Your Cart is Empty</td></tr>
			</c:if>
			
			<c:if test="${not empty cartItems}">
				<c:set var="cartCount" value="0" scope="page" />
				<c:forEach items="${cartItems}" var="cartItem">
					<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
						<tr>
							<td><c:out value="${cartCount + 1}" /></td>
							<td>${cartItem.productName}</td>
							<td>
								<input id="quantity" name="quantity" type="text" value="${cartItem.quantity}"/>
							</td>
							<td>${cartItem.price}</td>
							<td>${cartItem.quantity*cartItem.price} </td>
							<td>
								<input type="submit" value="update"/>
								<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>">Delete</a>
							</td>
						</tr>
					</form>
					<!-- <c:set var="cartCount" value="${cartCount + 1}" scope="page"/> -->
				</c:forEach>
			</c:if>
			<tr bgcolor="orange">
				<td colspan="4">Total Purchase Amount</td>
				<td colspan="2">${totalPurchaseAmount}</td>
			</tr>
			<tr bgcolor="Lightblue">
				<td colspan="3"><a href="<c:url value="/continueShopping"/>">Continue Shopping</a>
				<td colspan="3"><a href="<c:url value="/checkOut"/>">Checkout</a>
			</tr>
		</table>



	</body>
</html>