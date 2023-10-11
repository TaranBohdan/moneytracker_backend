
# MoneyTracker

The web-application (back-end) so that tracking money. Users can
manage and execute various operations on their wallets and
create entries in themself personal profile.





## API Reference

## Login

```http
  POST /login
```

#### Request
```javascript
{
  "password": "password",
  "username": "username"
}
```

#### Response
```javascript
{
    "tokens": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTY5NzA1NDIwNiwiaWF0IjoxNjk3MDUyNDA2fQ.E05cYFeenkLLwE118XgSpO2X_JmqJb22KRB9rU_QuzI"
    },
    "message": "Token was generated successfully!",
    "status": 200
}
```

## Sign up

```http
  POST /signup
```

#### Request
```javascript
{
    "username":"Test",
    "password":"Test",
    "confirmPassword":"Test"
}
```

#### Response
```javascript
{
    "message": "User was created successfully!",
    "users": {
        "id": 1,
        "username": "Test"
    },
    "status": 200
}
```
###

## Endpoints to WalletController
| Type | URL     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `GET`      | `/wallets` | Get all wallets |
| `Post`      | `/wallets` | Create wallet by id |
| `GET`      | `/wallets/{id}` | Get wallet by id |
| `PUT`      | `/wallets/{id}` | Updating wallet with id |
| `DELETE`      | `/wallets/{id}` | Removing wallet with id |
| `GET`      | `/wallets/amountexpenses` | Get amount of expenses from all wallet |
| `GET`      | `/wallets/cashflow` | Get cash flow |
| `GET`      | `/wallets/generalbalance` | Get general balance from all wallets |
