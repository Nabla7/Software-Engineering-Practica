# Refactoring of Payment

## Extract method
Used to extract `payment.m_amount += cost;` to a new function named `updatePaymentAmount`

## Replace Conditional with polymorphism
Used to create different payment classes in `Payment.java`

## Encapsulate Field
Made m_paymentCost private in `Payment` and used a getter to get the value.

## move behaviour close to data
Made a function pay inside of payment.

## other refactoring
Removed the OFFLINE statement as no code was executed in it.

## Other Refactoring
Changed the if/else if statements to a switch statement.