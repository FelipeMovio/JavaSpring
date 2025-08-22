SOBRE O PROJETO

dslist é uma aplicação back end contruída durante o intensivão de Java Spring,
ministrada pelo professor Nelio Alves do DevSuperior.

A aplicação consiste em uma API com uma lista de 10 jogos que pode ser vista atraves
do End Point '/games' (get) com uma subdescrição de cada jogo.
porem com o End Point '/games/{id}' (get) pode-se ter a busca de um jogo especificamente 
e recebendo descrição completa dele.

Mas esses 10 jogos tambem estão divididos em outras 2 sublistas,
que se pode ver com o End Point '/lists' (get).
Para ver os jogos que estão nas suas respectivas listas,
use o End Point '/lists/{listId}/games' (get).
E se deseja mudar a ordem das listas use o End Point
' /lists/{listId}/replacement ' (Post), e para informar 
o lugar de troca faça assim.

Exemplo:


<img width="626" height="200" alt="image" src="https://github.com/user-attachments/assets/f04fc796-50a0-41d5-95a1-a93ec93d1f07" />





TECNOLOGIAS UTILIZADAS :

Java

Spring Boot

JPA / HIbernate

Maven


