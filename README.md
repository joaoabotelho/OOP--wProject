# OOP-Project 17/18 - FCT Univ. Coimbra
## Descrição do Problema
Os alunos de Programação Orientada aos Objetos (POO) pretendem organizar
um serão de convívio com a comunidade do DEI e querem desenvolver uma
aplicação de suporte ao planeamento do evento. A noite de convívio contempla
a visita a vários locais em Coimbra incluindo parques, exposições e bares. A
aplicação deve permitir realizar as seguintes operações:
* Inscrição no convívio
* Seleção dos locais a visitar
* Seriação dos locais a visitar
* Visualização de “guest lists”
* Contabilização das receitas dos locais visitados
Todos os locais são caracterizados pelas suas coordenadas GPS. Os parques
podem ser jardins (caracterizados pela área) ou áreas desportivas
(caracterizadas pelo(s) desporto(s) que se pode(m) praticar). As exposições
são caracterizadas pela forma artística (“Pintura”, “Escultura”, ou outra) e pelo
custo do ingresso. Os bares são caracterizados pela lotação e valor do
consumo mínimo.

Os elementos da comunidade do DEI podem ser professores, funcionários ou
estudantes. Cada pessoa tem um perfil que pode ser “Desportivo”, “Cultural”,
“Boémio” ou “Poupadinho”. As diferenças principais entre as pessoas são as
seguintes:
* Os professores podem ser “Auxiliar”, “Associado” ou “Catedrático”
* Os funcionários podem ser a “Tempo parcial” ou “Tempo integral”
* Os alunos pertencem a um curso.

A aplicação deve permitir realizar as seguintes operações:

### Inscrição no convívio
* A inscrição está restrita aos membros da comunidade do DEI
* Cada pessoa deve inserir uma palavra chave para controlo de
acesso

### Apresentação dos locais a visitar
* Após a inscrição, a aplicação deve mostrar a lista dos locais que
podem ser visitados
* A aplicação dever permitir visualizar o número atual de inscritos em
cada local e a lotação (quando se aplica)

### Seleção dos locais a visitar
* Cada pessoa inscrita deve selecionar até 5 locais que pretende
visitar durante o serão de convívio

### Seriação dos locais a visitar
* A aplicação deve permitir apresentar uma lista ordenada de locais a
visitar por ordem decrescente do número de inscrições

### Visualização da “guest lists”
* A aplicação deve permitir visualizar uma “guest list” para cada bar
* O número máximo de convidados em cada “guest list” corresponderá
a uma percentagem da sua lotação, a definir na configuração da
aplicação
* A introdução das pessoas nas “guest lists” é realizada por ordem de
inscrição. No entanto, as pessoas com perfil “Boémio” têm prioridade
no acesso às “guest lists” podendo substituir utilizadores com outro
perfil
* Cada pessoa na “guest list” deve ser apresentada com o seguinte
formato:
```
  Aluno: nome, perfil e curso
  Professor e Funcionário: nome e perfil
```

### Contabilização das receitas dos locais visitados
* A aplicação deve permitir apresentar o valor mínimo de receita
prevista para o evento tendo em consideração as inscrições
existentes e os locais a frequentar
* Deve considerar que os alunos têm um desconto de 10% no preço
da entrada nas exposições

A interação com o utilizador deverá ser realizada através de uma **interface
gráfica**. A aplicação deve ser disponibilizada com **ficheiros de texto** contendo
dados relativos à comunidade e locais a visitar (pelo menos 10 elementos de
cada categoria). Estes ficheiros devem apenas ser lidos quando ainda não
houve inscrições. Após a realização da primeira inscrição, todos os dados
devem ser guardados em **ficheiros de objetos** e carregados sempre que a
aplicação for iniciada.

## Implementação
A aplicação deve ser implementada na linguagem Java e deverá ter em conta
os seguintes aspetos:
* Cada classe deve gerir internamente os seus dados, pelo que deverá
cuidar da proteção das suas variáveis e métodos
* Cada objeto deverá ser responsável por uma tarefa ou objetivo
específico, não lhe devendo ser atribuídas funções indevidas
* Utilize a *keyword* **static** apenas quando tal se justifique e não para
contornar erros do compilador

Elabore um diagrama com as suas classes (em UML) antes de iniciar a
implementação, para prever a estrutura do projeto.

Tenha ainda em conta os seguintes pontos que serão importantes na avaliação:

* Comentar as classes, métodos e variáveis públicas segundo o formato
Javadoc. Isto permitir-lhe-á gerar automaticamente uma estrutura de
ficheiros HTML, descritivos do seu código, que deve incluir no seu
relatório
* Comentar o restante código sempre que a leitura dos algoritmos não
seja óbvia
* Tal como sugerido acima, evitar o uso abusivo de **static** e de variáveis e
métodos **public**
* Na escolha de nomes para variáveis, classes e métodos, seguir as
convenções adotadas na linguagem **Java**
* Na organização das classes deverá ser evitada a redundância dos
dados
