<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Final Exam</h1>
	<a href="/addItem">Add Item</a>
	<table>
		<thead>
			<tr>
				<th><b>Item</b></th>
				<th><b>Store</b><th>
				<th><b>Operation</b><th>
			</tr>
		</thead>
		<tbody>
			<#list items as item>
        	<tr>
            	<td>${item.name}</td>
            	<td>${item.store.name}</td>
            	<td><a href="/deleteItem/${item.id}">Delete</a></td>
        	</tr>
        	</#list>
		</tbody>
	</table>
</body>
</html>