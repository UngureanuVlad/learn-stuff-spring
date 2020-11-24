<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<div class="padding_container">
			<c:forEach var="artistsList" items="${artists}">
				<div class="list_items">
					<span class="bold_font"><c:out
							value="${artistsList.name}" /></span>
							<!-- using the relative path in the URL -->
							<a class= "fct_btn" href="update_artist/${artistsList.id}">Update</a><br />
					<div class="left_spacing">Albums:</div>
					<ul>
						<c:forEach var="albumsList" items="${artistsList.albums}">
							<li><div class="editor-rez, title-width">
									<c:out value="${albumsList.title}" /> 
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
</div>