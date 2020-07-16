create database sistesouraria_teste;
use sistesouraria_teste;

create table nivelacesso(

niv_codigo int not null auto_increment primary key,

niv_descricao varchar(20)not null
);

create table usuario(
usu_codigo int not null auto_increment primary key, 

usu_nome varchar(50)not null,

usu_login varchar(10)not null,

usu_senha varchar(10)not null,

fk_nivel int not null,

foreign key(fk_nivel)references nivelacesso(niv_codigo)
);

create table celula(

cel_codigo int not null auto_increment primary key,

cel_nome varchar(30)not null,

cel_lider varchar(20)not null
);



create table fiel(

fie_nome varchar(50)not null,

fie_cpf int not null primary key,
fk_celula int not null,

foreign key(fk_celula)references celula(cel_codigo)
);



create table tipo(

tip_codigo int not null auto_increment primary key,

tip_descricao varchar(20)not null
);

create table movimento(
mov_codigo int not null primary key,
mov_saldototal double
);

create table receita(
rec_codigo int not null auto_increment primary key,

rec_titulo varchar(20)not null,
rec_data date not null, 
rec_valor double not null,
rec_hora varchar(20)not null,
fk_usuario int not null,
fk_fiel int,
fk_tipo int ,
fk_movimento int,
foreign key(fk_usuario)references usuario(usu_codigo),
foreign key(fk_fiel)references fiel(fie_cpf),
foreign key(fk_tipo)references tipo(tip_codigo),
foreign key(fk_movimento)references movimento(mov_codigo)
);

create table prestador(

pre_id int not null primary key,
pre_nome varchar(50)not null 

);

create table despesa(
des_codigo int not null auto_increment primary key,
des_titulo varchar(20)not null,
des_descricao varchar(20) not null,
des_status varchar(20)not null,
fk_prestador int not null,
foreign key(fk_prestador)references prestador(pre_id)
);

create table pagamento(

pag_codigo int not null auto_increment primary key,

pag_titulo varchar(20),
pag_data date not null,
pag_valor double not null,
pag_hora varchar(20),
fk_despesa int not null,
fk_movimento int not null,
fk_usuario int not null,
foreign key(fk_despesa)references despesa(des_codigo),
foreign key(fk_movimento)references movimento(mov_codigo),
foreign key(fk_usuario)references usuario(usu_codigo)
);

create table servico(
ser_codigo int not null auto_increment primary key,
ser_descricao varchar(20)not null,
ser_titulo varchar(20)not null,
ser_dataservico date not null,
ser_hora varchar(20)not null,
fk_prestador int not null,
foreign key(fk_prestador)references prestador(pre_id)
);

INSERT INTO nivelacesso VALUES (1,'Tesoureiro'),(2,'Dirigente');

DELIMITER $$
CREATE TRIGGER tg_calcularsaldototal_despesa AFTER INSERT ON PAGAMENTO
    FOR EACH ROW
   BEGIN
    
    update movimento set mov_saldototal=mov_saldototal - NEW.pag_valor
    where mov_codigo=new.fk_movimento;
    
    END$$
    DELIMITER;

DELIMITER $$
CREATE trigger tg_atualizavalortotal_despesa after update on pagamento
for each row
begin 
update movimento set mov_saldototal=mov_saldototal-des_valor
where mov_codigo=fk_movimento;
end$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tg_calcularsaldototal AFTER INSERT ON RECEITA
    FOR EACH ROW
   BEGIN
    
    update movimento set mov_saldototal=mov_saldototal + NEW.rec_valor
    where mov_codigo=new.fk_movimento;
    
    END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tg_atualizasaldototal AFTER UPDATE ON RECEITA
    FOR EACH ROW
   BEGIN
    
    update movimento set mov_saldototal=mov_saldototal + NEW.rec_valor
    where mov_codigo=new.fk_movimento;
    
    END $$
DELIMITER ;


