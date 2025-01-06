## Overview
The Bakery Store API allows users to manage bakery items, orders, and customers.

## Tech Stack
- **Backend:** Spring Boot
- **Database:** MySQL
- **Testing Tool:** Postman

---

## Endpoints

### Bakery Item Endpoints
1. **Get All Items**
   - **Endpoint:** `GET /bakery-items/all`
   - **Description:** Fetches all bakery items.
   - **Response Example:**
     ```json
     [
       {
         "id": 1,
         "name": "Chocolate Cake",
         "price": 15.99,
         "description": "Delicious chocolate cake"
       }
     ]
     ```

2. **Get Item by ID**
   - **Endpoint:** `GET /bakery-items/details/{id}`
   - **Description:** Fetches a bakery item by its ID.
   - **Response Example:**
     ```json
     {
       "id": 1,
       "name": "Chocolate Cake",
       "price": 15.99,
       "description": "Delicious chocolate cake"
     }
     ```

3. **Search Items**
   - **Endpoint:** `GET /bakery-items/search?keyword={keyword}`
   - **Description:** Searches bakery items by keyword.
   - **Response Example:**
     ```json
     [
       {
         "id": 1,
         "name": "Chocolate Cake",
         "price": 15.99,
         "description": "Delicious chocolate cake"
       }
     ]
     ```

4. **Add a New Item**
   - **Endpoint:** `POST /bakery-items/add`
   - **Description:** Adds a new bakery item.
   - **Request Body Example:**
     ```json
     {
       "name": "Blueberry Muffin",
       "price": 3.50,
       "description": "A soft blueberry muffin"
     }
     ```

5. **Update an Item**
   - **Endpoint:** `PUT /bakery-items/update/{id}`
   - **Description:** Updates an existing bakery item by its ID.
   - **Request Body Example:**
     ```json
     {
       "name": "Updated Cake",
       "price": 16.99,
       "description": "Updated chocolate cake description"
     }
     ```

6. **Delete an Item**
   - **Endpoint:** `DELETE /bakery-items/delete/{id}`
   - **Description:** Deletes a bakery item by its ID.
   - **Response:** `204 No Content`

---

### Bakery Order Endpoints
1. **Get All Orders**
   - **Endpoint:** `GET /orders/all`
   - **Description:** Fetches all orders.
   - **Response Example:**
     ```json
     [
       {
         "orderId": 1,
         "customerId": 101,
         "orderDate": "2023-12-23",
         "items": [
           {
             "id": 1,
             "name": "Chocolate Cake",
             "price": 15.99
           }
         ],
         "totalAmount": 15.99
       }
     ]
     ```

2. **Get Order by ID**
   - **Endpoint:** `GET /orders/details/{id}`
   - **Description:** Fetches an order by its ID.
   - **Response Example:**
     ```json
     {
       "orderId": 1,
       "customerId": 101,
       "orderDate": "2023-12-23",
       "items": [
         {
           "id": 1,
           "name": "Chocolate Cake",
           "price": 15.99
         }
       ],
       "totalAmount": 15.99
     }
     ```

3. **Add a New Order**
   - **Endpoint:** `POST /orders/add`
   - **Description:** Adds a new order.
   - **Request Body Example:**
     ```json
     {
       "customerId": 101,
       "items": [1, 2],
       "totalAmount": 18.99
     }
     ```

4. **Update an Order**
   - **Endpoint:** `PUT /orders/update/{id}`
   - **Description:** Updates an existing order.
   - **Request Body Example:**
     ```json
     {
       "customerId": 101,
       "items": [1],
       "totalAmount": 15.99
     }
     ```

5. **Delete an Order**
   - **Endpoint:** `DELETE /orders/delete/{id}`
   - **Description:** Deletes an order by its ID.
   - **Response:** `204 No Content`

---

### Customer Endpoints
1. **Get All Customers**
   - **Endpoint:** `GET /customers/all`
   - **Description:** Fetches all customers.
   - **Response Example:**
     ```json
     [
       {
         "customerId": 101,
         "name": "John Doe",
         "email": "johndoe@example.com",
         "phone": "123-456-7890"
       }
     ]
     ```

2. **Get Customer by ID**
   - **Endpoint:** `GET /customers/details/{id}`
   - **Description:** Fetches a customer by their ID.
   - **Response Example:**
     ```json
     {
       "customerId": 101,
       "name": "John Doe",
       "email": "johndoe@example.com",
       "phone": "123-456-7890"
     }
     ```

3. **Search Customers**
   - **Endpoint:** `GET /customers/search?keyword={keyword}`
   - **Description:** Searches customers by keyword.
   - **Response Example:**
     ```json
     [
       {
         "customerId": 101,
         "name": "John Doe",
         "email": "johndoe@example.com",
         "phone": "123-456-7890"
       }
     ]
     ```

4. **Add a New Customer**
   - **Endpoint:** `POST /customers/add`
   - **Description:** Adds a new customer.
   - **Request Body Example:**
     ```json
     {
       "name": "Jane Smith",
       "email": "janesmith@example.com",
       "phone": "987-654-3210"
     }
     ```

5. **Update a Customer**
   - **Endpoint:** `PUT /customers/update/{id}`
   - **Description:** Updates an existing customer.
   - **Request Body Example:**
     ```json
     {
       "name": "Jane Doe",
       "email": "janedoe@example.com",
       "phone": "987-654-3210"
     }
     ```

6. **Delete a Customer**
   - **Endpoint:** `DELETE /customers/delete/{id}`
   - **Description:** Deletes a customer by their ID.
   - **Response:** `204 No Content`

---
