# TCCUSJT
Investimento

#Rotas Api

GET /api/investimentos
Obter todos os investimentos.

GET /api/investimento/{id}
Obter um investimento de acordo com o id passado na url.

GET /investimento/delete/{id}
Deletar um investimento de acordo com o id passado na url.

POST /investimento
Inserir ou Atualizar um investimento.

Headers exemplo:
[{"key":"Content-Type","value":"application/json","description":""}]

Body Inserir exemplo:

{
    "valorInicial": 1750,
    "valorMensal": 200,
    "dataInclusao": "2020-05-08",
    "idTipoInvestimento": 1
}

Body Atualizar exemplo:

{
    "id": 1,
    "valorInicial": 1750,
    "valorMensal": 200,
    "dataInclusao": "2020-05-08",
    "idTipoInvestimento": 1
}