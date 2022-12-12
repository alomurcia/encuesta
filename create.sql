create sequence encuesta_seq start with 1 increment by 50;
create sequence marca_seq start with 1 increment by 50;
create table encuesta (id bigint not null, comentarios varchar(255), email varchar(255), fecha_respuesta timestamp(6), num_documento bigint, marca_id bigint not null, primary key (id));
create table marca (id bigint not null, nombre varchar(255), primary key (id));
alter table if exists encuesta add constraint FKip2lhp6ixr6n1njt8igstsc4t foreign key (marca_id) references marca;
