# project_trip

# Projeto relacionado ao tratamento da base de dados de uma locadora de veículos, as informações armazenadas referem-se a telemetria dos veículos em suas respectivas viagens

# O objetivo é o usuário conseguir visualizar o do total de viagens realizadas, total de quilômetros percorridos, tempo total em movimento e tempo total parado por veículo

# Para isso, primeiramente foi criado no próprio banco de dados outra tabela (trip_import) para tratar os dados da tabela geral e fazer os cálculos necessários. Em seguida, criou-se uma query para realizar a inserção das informações dentro da nova tabela.

# A nova tabela trip_import contou os seguintes campos: placa, qtade_viagem, km_percorrido, tempo_movimento, tempo_parado, mes_viagem e data_processamento. A placa como é uma sequência única e não vai se repetir neste caso, funciona como uma chave-primária, os outros campo referem-se ao valor total das viagens, tempo total do veiculo em movimento e parado e km total percorrido. O campo mes_viagem refere-se ao mês que a viagem foi realizada e o campo data_processamento, seria a data do último processamento da query criada.

# Como houve a necessidade de transportar esses dados para um arquivo (extensão csv) foi necessário codificar um aplicativo para realizar esta função, sendo que este foi desenvolvido na linguagem java e conectado ao banco de dados gerando o csv com as informações da nova tabela.

# A partir dos dados consolidados e o arquivo gerado, utilizou-se uma ferramenta de BI para criar um dashboard, com o objetivo de sintetizar de forma visual as informações compiladas.

# Passos para a execução do projeto:

# Para este projeto foram utilizadas as seguintes ferramentas: Banco de Dados PostgreSQL, Docker para virtualização e acesso a base de dados, Dbeaver para a administração e gerenciamento do banco, como criação e manipulação dos dados, Netbeans como IDE de desenvolvimento para a linguagem Java e o Data Studio para a criação do dashboard.

# 1 - Com acesso ao banco de dados deve rodar o script "script_trip.sql". Este arquivo contém a criação da tabela "trip_import", responsável por armazenar as informações as informações já tratadas. O comando insert é necessário para popular a tabela criada. E, caso a tabela principal seja atualizada constantemente, basta configurar o insert para rodar pelo menos 1 vez ao dia, por exemplo através de uma job, isto depois do comando truncate, necessário para limpar a tabela fato e carregar os dados novamente com as informações atualizadas. 

# Ainda sobre a estrutura do banco, caso novas informações venham a ser inseridas ou haja a necessidade de obter novos conhecimentos, pode-se criar também algumas tabelas de dimensão para apoiar a tabela fato.

# Esta estapa pode ser realizada em qualquer ferramenta de administração de banco de dados que tenha integração com o PostgreSQL.

# 2 - Deve-se rodar o projeto Java intitulado Trip em alguma IDE que aceite a linguagem de programação. Para se evitar contratempos, recomenda-se utilizar o Netbaens com a versão mais atualizada.

# Caso utilize o Netbeans, deve instalar o JDK 8 ou superior e o driver JDBC referente a conexão do PostgreSQL, para que o programa funcione corretamente e gere o arquivo csv intitulado result_trip.csv

# 3 - Para visualizar o dashboard no Data Studio, basta acessar o seguinte link: https://datastudio.google.com/s/le0gKapFld8

# Observações: O script sql e o projeto java encontra-se aqui no Github.
