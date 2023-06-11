DELIMITER //

CREATE TRIGGER atualizar_estoque BEFORE INSERT ON vendas
FOR EACH ROW
BEGIN
    DECLARE estoque_disponivel FLOAT;
    SELECT qtde INTO estoque_disponivel FROM estoque WHERE id_estoque = NEW.id_estoque;
    
    IF estoque_disponivel >= NEW.qtde THEN
        UPDATE estoque SET qtde = qtde - NEW.qtde WHERE id_estoque = NEW.id_estoque;
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Estoque insuficiente.';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER controle_uso_materia_prima BEFORE INSERT ON producao
FOR EACH ROW
BEGIN
    DECLARE aprovacao FLOAT;
    SELECT aprovacao INTO aprovacao FROM resultados_testes WHERE id_lote_mp = NEW.id_lote_mp;
    
    IF aprovacao != 'A' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Matéria prima reprovada nos testes.';
    END IF;
END //

DELIMITER ;

-- Função para calcular desconto conforme histórico de compra do cliente