Короткий опис:

Створюється 3 асинхронних завдання:
 - перше виконується 3 секунди
 - друге виконується 1 секунду
 - третє виконується 2 секунди

Далі викликається anyOf() з трьох завдань, і воно повертає результат завдання, що виконається першим, а саме другого завдання, яке виконується меньше за всіх(1 секнду).
