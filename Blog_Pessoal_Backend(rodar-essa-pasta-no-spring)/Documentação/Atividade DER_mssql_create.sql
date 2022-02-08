CREATE TABLE [Temas] (
	id bigint(40) NOT NULL,
	descricao varchar(255),
  CONSTRAINT [PK_TEMAS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [Postagens] (
	id bigint(40) NOT NULL,
	titulo varchar(255) NOT NULL,
	texto varchar(1000) NOT NULL,
	data timestamp NOT NULL,
	tema_id bigint NOT NULL,
	usuario_id bigint NOT NULL,
  CONSTRAINT [PK_POSTAGENS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [Usuários] (
	id bigint(40) NOT NULL,
	nome varchar(255) NOT NULL,
	usuario varchar(255) NOT NULL,
	senha varchar(255) NOT NULL,
  CONSTRAINT [PK_USUÁRIOS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO

ALTER TABLE [Postagens] WITH CHECK ADD CONSTRAINT [Postagens_fk0] FOREIGN KEY ([tema_id]) REFERENCES [Temas]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [Postagens] CHECK CONSTRAINT [Postagens_fk0]
GO
ALTER TABLE [Postagens] WITH CHECK ADD CONSTRAINT [Postagens_fk1] FOREIGN KEY ([usuario_id]) REFERENCES [Usuários]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [Postagens] CHECK CONSTRAINT [Postagens_fk1]
GO


