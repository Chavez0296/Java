<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>
</head>
<body>
	<h1>Add Item</h1>
    <form action="/addItem" method="post">
    <div>
        <label for="name">Item Name:</label>
        <input type="text" id="name" name="name" required/>
    </div>
    <div>
        <label for="store">Store:</label>
        <select id="store" name="storeName">
            <option value="">Select a store</option>
            <#list stores as store>
                <option value="${store.id}">${store.name}</option>
            </#list>
            <option value="newStore">Add new store</option>
        </select>
    </div>
    <div>
        <label for="newStoreName">New Store Name (if adding new store):</label>
        <input type="text" id="newStoreName" name="newStoreName" />
    </div>
    <div>
        <button type="submit">Add Item</button>
    </div>
</form>
</body>
</html>