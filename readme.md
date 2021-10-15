# User Service

PORT: 8600

spring.application.name=user-service

### GET: /api/subscriptions/{userId}

return: (if the user doesn't have an active subscription today, returns a null body)

    "userId": Long,
    "subscriptionPackStart": String,
    "subscriptionPackEnd": String,
    "paymentId": String

### POST: /api/subscriptions

body:

    "userId": Long, (validates if it is a valid user Id calling user-service)
    "subscriptionPackStart": String,
    "subscriptionPackEnd": String

saves in repository and returns a SubscriptionPack instance
