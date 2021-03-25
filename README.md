# apiprodutos

### **Acesse a aplicacao em:** 
http://localhost:9999

### **Para verificar a tabela via terminal:**
```
# \d
```
### **Acesse o Swagger em:** 
http://localhost:9999/swagger-ui.html


### **Deploy da aplicacao:**
1. Instale o heroku: https://devcenter.heroku.com/articles/
heroku-cli 
1. Entre na sua conta heroku:
    - https://dashboard.heroku.com
    - Selecione "Create new app"
    - Escreva o nome da aplicacao e siga o passo a passo indicado

1. Entre no diratorio da aplicacao via terminal:
     - ```bash
        $  cd $HOME/Workspace/apiprodutos
        ```
    - ```bash
        $  heroku login
        ```
    - Siga o passo a passo git em: https://dashboard.heroku.com

    - Por fim suba a aplicacao com:
        ```
        $ git push heroku master
        ```

