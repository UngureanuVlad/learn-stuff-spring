
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<sf:form action="/learn-stuff-spring-mvc/artist"
			method="POST" modelAttribute="artist">
			<input type="hidden" name="_method" value="POST" />
			<input type="hidden" name="id" value="${artist.id}" />
			<div class="padding_container">
				<table>
					<tr>
						<td><label for="name"
							class="artist_form_label">Artist
								Name:</label></td>
						<td><sf:input path="name" size="15" id="name"
								class="vertical_middle" /> <sf:errors path="name"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="origin"
							class="artist_form_label">Artist
								Origin:</label></td>
						<td><sf:input path="origin" size="15" id="origin"
								class="vertical_middle" /> <sf:errors path="origin"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="details"
							class="artist_form_label">Artist
								Details:</label></td>
						<td><sf:input path="details" size="15" id="details"
								class="vertical_middle" /> <sf:errors path="details"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="launchDate"
							class="artist_form_label">Artist
								Launch Date:</label></td>
						<td><sf:input type="date" path="launchDate" id="launchDate"
								class="vertical_middle" /> <sf:errors path="launchDate"
								cssClass="error" /></td>
					</tr>

				</table>
			</div>
			<div class="button-wrapper">
				<div class="button_holder">
					<input name="commit" type="submit" value="Create Artist"
						class="btn" />
					<!-- using the actual application name in the URL -->
					<a href="/learn-stuff-spring-mvc/list_artists" class="btn"
						class="left_spacing">Cancel/Back</a>
				</div>
			</div>
		</sf:form>
	</div>
</div>