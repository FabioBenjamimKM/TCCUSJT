# https://www.investing.com/equities/brazil-adrs
# https://br.investing.com/indices/brazil-indices?

TICKERS = {
    'AFYA': 'Afya Ltd',
    'ABEV': 'AMBEV S.A',
    'ARCE': 'Arco Platform',
    'AZUL': 'Azul SA',
    'BTOOY': 'B2W Companhia Digital ADR',
    'BBD': 'Banco Bradesco SA',
    'BBDO': 'Banco Bradesco S/A',
    'BDORY': 'Banco Do Brasil SA',
    'BSBR': 'Banco Santander Brasil SA',
    'BBSEY': 'BB Seguridade Participacoes SA',
    'LND': 'Brasilagro Adr',
    'BAK': 'Braskem',
    'BMIX': 'Brazil Minerals Inc',
    'BRFS': 'BRF S.A.',
    'BRMSY': 'Brmalls Par',
    'CIG': 'CEMIG - Companhia Energetica Minas Gerais',
    'EBR': 'Centrais Eletricas Brasileiras',
    'CIOXY': 'Cielo SA',
    'CBD': 'Companhia Brasileira de Distribuica',
    'ELP': 'Companhia Paranaense de Energia COPEL',
    'CZZ': 'Cosan Ltd',
    'SID': 'Companhia Siderurgica Nacional-CSN',
    'CPL': 'CPFL Energia',
    'CREIY': 'CR2 Empreendimentos Imobiliarios SA',
    'CTPTY': 'CTEEP Companhia de Transmissao de Energia Eletrica Paulista',
    'CYRBY': 'Cyrela Brazil Realty',
    'CYRLY': 'Cyrela Commercial Properties SA Empreendimentos e Participacoes',
    'DMMOY': 'Dommo Energia SA',
    'ERJ': 'Embraer',
    'EGIEY': 'Engie Brasil Energia SA',
    'EQUEY': 'Equatorial Energia SA ADR',
    'YDUQY': 'Estacio Participacoes Sa',
    'FBR': 'Fibria Celulose',
    'GFASY': 'Gafisa',
    'GGB': 'Gerdau',
    'GOL': 'Gol Linhas',
    'HYPMY': 'Hypera SA',
    'IOCJY': 'Iochpe Maxion SA',
    'BOVA11.SAO': 'iShares Ibovespa Fundo de Índice ETF',
    'ITUB': 'Itau Unibanco',
    'JBSAY': 'JBS SA',
    'KLBAY': 'Klabin Sa A',
    'COGNY': 'Kroton Edct',
    'LGSXY': 'Light SA ADR',
    'LZRFY': 'Localiza Rent A Car SA',
    'LUPAQ': 'Lupatech SA',
    'MRRTY': 'Marfrig Global Foods SA',
    'MILTY': 'Mills Estruturas e Servicos de Engenharia SA',
    'MRVSY': 'Minerva SA',
    'OIBR-C': 'Oi',
    'PAGS': 'PagSeguro Digital Ltd',
    'ELPVY': 'Companhia Paranaense de Energia-Copel',
    'PDGRY': 'PDG Realty SA Empreendimentos e Participacoes',
    'PBR': 'Petroleo Brasileiro-Petrobras',
    'RADLY': 'Raia Drogasil SA',
    'DEIPY': 'Rio Paranapanema Energia SA',
    'SBS': 'SABESP',
    'SLCJY': 'SLC Agricola SA',
    'SUZ': 'Suzano Papel e Celulose SA',
    'VIV': 'Telefonica Brasil SA',
    'TSU': 'TIM Participacoes',
    'UGP': 'Ultrapar',
    'USNZY': 'Usinas Siderurgicas de Minas Gerais',
    'VALE': 'Vale',
    'VSSPY': 'Valid Solucoes e Servicos de Seguranca em Meios de Pagamento e Identificacao SA',
    'WEGZY': 'WEG',
    'XP': 'Xp Inc',
}

TABLE_NAMES = {
    'investment_type': 'tb_tipo_investimento',
    'investment': 'tb_investimento',
    'stock': 'tb_acao',
    'dollar': 'tb_dolar_real',
    'income_variable_type': 'tb_tipo_rendimento_variavel',
    'income_variable': 'tb_rendimento_variavel',
    'fixed_income': 'tb_renda_fixa',
}

USD_BRL_NAME = 'Paridade Dólar/Real'

INVESTMENT_TYPE = {
    'fixed_income': 'Renda Fixa',
    'variable_income': 'Renda Variável'
}

EXCHANGE_RATE_SYMBOLS = {
    'from_symbol': 'USD',
    'to_symbol': 'BRL'
}
