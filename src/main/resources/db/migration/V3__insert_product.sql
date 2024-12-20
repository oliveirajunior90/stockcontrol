INSERT INTO product (name, description, price, ingredient, slug) VALUES
             ( 'Bolo de Cenoura', 'Bolo fofinho de cenoura com cobertura de chocolate', 25.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.5, "unity": "kg", "slug": "farinha"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 3, "unity": "unidades", "slug": "ovos"},
                {"id": 5, "name": "Leite", "quantity_in_stock": 0.25, "unity": "litros", "slug": "leite"},
                {"id": 6, "name": "Cacau em Pó", "quantity_in_stock": 0.1, "unity": "kg", "slug": "cacau-em-po"}]', 'bolo-de-cenoura'),

             ( 'Pudim de Leite', 'Pudim cremoso de leite condensado', 18.00,
              JSON '[{"id": 5, "name": "Leite", "quantity_in_stock": 0.5, "unity": "litros", "slug": "leite"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.3, "unity": "kg", "slug": "acucar"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 4, "unity": "unidades", "slug": "ovos"},
                {"id": 11, "name": "Canela", "quantity_in_stock": 0.02, "unity": "kg", "slug": "canela"}]', 'pudim-de-leite'),

             ( 'Torta de Limão', 'Torta com recheio de limão e merengue', 30.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.3, "unity": "kg", "slug": "farinha"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.15, "unity": "kg", "slug": "acucar"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 2, "unity": "unidades", "slug": "ovos"},
                {"id": 5, "name": "Leite", "quantity_in_stock": 0.2, "unity": "litros", "slug": "leite"},
                {"id": 18, "name": "Raspas de Limão", "quantity_in_stock": 0.01, "unity": "kg", "slug": "raspas-de-limao"}]', 'torta-de-limao'),

             ( 'Pão de Queijo', 'Pão de queijo mineiro quentinho', 15.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.25, "unity": "kg", "slug": "farinha"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.05, "unity": "kg", "slug": "acucar"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 2, "unity": "unidades", "slug": "ovos"},
                {"id": 11, "name": "Canela", "quantity_in_stock": 0.01, "unity": "kg", "slug": "canela"}]', 'pao-de-queijo'),

             ( 'Brownie de Chocolate', 'Brownie rico e denso de chocolate', 22.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.2, "unity": "kg", "slug": "farinha"},
                {"id": 6, "name": "Cacau em Pó", "quantity_in_stock": 0.15, "unity": "kg", "slug": "cacau-em-po"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.25, "unity": "kg", "slug": "acucar"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 3, "unity": "unidades", "slug": "ovos"},
                {"id": 10, "name": "Gotas de Chocolate", "quantity_in_stock": 0.1, "unity": "kg", "slug": "gotas-de-chocolate"}]', 'brownie-de-chocolate'),

             ( 'Bolo de Banana', 'Bolo úmido de banana com especiarias', 20.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.3, "unity": "kg", "slug": "farinha"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.15, "unity": "kg", "slug": "acucar"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 3, "unity": "unidades", "slug": "ovos"},
                {"id": 18, "name": "Bananas", "quantity_in_stock": 2, "unity": "unidades", "slug": "bananas"},
                {"id": 11, "name": "Canela", "quantity_in_stock": 0.01, "unity": "kg", "slug": "canela"}]', 'bolo-de-banana'),

             ( 'Creme de Morango', 'Creme suave de morango para sobremesa', 14.00,
              JSON '[{"id": 13, "name": "Morangos", "quantity_in_stock": 0.3, "unity": "kg", "slug": "morangos"},
                {"id": 5, "name": "Leite", "quantity_in_stock": 0.25, "unity": "litros", "slug": "leite"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.1, "unity": "kg", "slug": "acucar"}]', 'creme-de-morango'),

             ( 'Salada de Frutas', 'Mistura refrescante de frutas da estação', 12.00,
              JSON '[{"id": 18, "name": "Bananas", "quantity_in_stock": 1, "unity": "unidades", "slug": "bananas"},
                {"id": 18, "name": "Laranjas", "quantity_in_stock": 2, "unity": "unidades", "slug": "laranjas"},
                {"id": 18, "name": "Maçãs", "quantity_in_stock": 2, "unity": "unidades", "slug": "macas"},
                {"id": 18, "name": "Kiwi", "quantity_in_stock": 1, "unity": "unidades", "slug": "kiwi"}]', 'salada-de-frutas'),

             ( 'Smoothie de Frutas', 'Bebida refrescante de frutas misturadas', 10.00,
              JSON '[{"id": 13, "name": "Morangos", "quantity_in_stock": 0.2, "unity": "kg", "slug": "morangos"},
                {"id": 18, "name": "Bananas", "quantity_in_stock": 1, "unity": "unidades", "slug": "bananas"},
                {"id": 18, "name": "Laranjas", "quantity_in_stock": 0.5, "unity": "unidades", "slug": "laranjas"},
                {"id": 5, "name": "Leite", "quantity_in_stock": 0.2, "unity": "litros", "slug": "leite"}]', 'smoothie-de-frutas'),

             ( 'Bolo de Chocolate', 'Bolo recheado com chocolate e cobertura', 28.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.5, "unity": "kg", "slug": "farinha"},
                {"id": 6, "name": "Cacau em Pó", "quantity_in_stock": 0.1, "unity": "kg", "slug": "cacau-em-po"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.25, "unity": "kg", "slug": "acucar"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 4, "unity": "unidades", "slug": "ovos"},
                {"id": 10, "name": "Gotas de Chocolate", "quantity_in_stock": 0.15, "unity": "kg", "slug": "gotas-de-chocolate"}]', 'bolo-de-chocolate'),

             ( 'Suflê de Queijo', 'Suflê leve e cremoso de queijo', 30.00,
              JSON '[{"id": 18, "name": "Queijo", "quantity_in_stock": 0.2, "unity": "kg", "slug": "queijo"},
                {"id": 1, "name": "Farinha", "quantity_in_stock": 0.1, "unity": "kg", "slug": "farinha"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 3, "unity": "unidades", "slug": "ovos"},
                {"id": 5, "name": "Leite", "quantity_in_stock": 0.2, "unity": "litros", "slug": "leite"}]', 'sufle-de-queijo'),

             ( 'Frango Assado', 'Frango assado com temperos', 50.00,
              JSON '[{"id": 12, "name": "Frango", "quantity_in_stock": 1, "unity": "kg", "slug": "frango"},
                {"id": 18, "name": "Sal", "quantity_in_stock": 0.01, "unity": "kg", "slug": "sal"},
                {"id": 18, "name": "Pimenta-do-Reino", "quantity_in_stock": 0.01, "unity": "kg", "slug": "pimenta-do-reino"}]', 'frango-assado'),

             ( 'Bacalhau à Brás', 'Prato típico de bacalhau com batata e ovos', 45.00,
              JSON '[{"id": 18, "name": "Bacalhau", "quantity_in_stock": 0.2, "unity": "kg", "slug": "bacalhau"},
                {"id": 18, "name": "Batata", "quantity_in_stock": 0.3, "unity": "kg", "slug": "batata"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 3, "unity": "unidades", "slug": "ovos"},
                {"id": 18, "name": "Cebola", "quantity_in_stock": 0.1, "unity": "kg", "slug": "cebola"}]', 'bacalhau-a-bras'),

             ( 'Salada Caesar', 'Salada com alface, croutons e molho Caesar', 25.00,
              JSON '[{"id": 18, "name": "Alface", "quantity_in_stock": 0.5, "unity": "kg", "slug": "alface"},
                {"id": 18, "name": "Frango", "quantity_in_stock": 0.2, "unity": "kg", "slug": "frango"},
                {"id": 18, "name": "Queijo", "quantity_in_stock": 0.05, "unity": "kg", "slug": "queijo"},
                {"id": 18, "name": "Croutons", "quantity_in_stock": 0.1, "unity": "kg", "slug": "croutons"}]', 'salada-caesar'),

             ( 'Mousse de Chocolate', 'Mousse leve e aerada de chocolate', 28.00,
              JSON '[{"id": 6, "name": "Cacau em Pó", "quantity_in_stock": 0.1, "unity": "kg", "slug": "cacau-em-po"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 4, "unity": "unidades", "slug": "ovos"},
                {"id": 5, "name": "Leite", "quantity_in_stock": 0.2, "unity": "litros", "slug": "leite"},
                {"id": 2, "name": "Açúcar", "quantity_in_stock": 0.2, "unity": "kg", "slug": "acucar"}]', 'mousse-de-chocolate'),

             ( 'Torta de Frango', 'Torta salgada de frango desfiado', 35.00,
              JSON '[{"id": 1, "name": "Farinha", "quantity_in_stock": 0.4, "unity": "kg", "slug": "farinha"},
                {"id": 4, "name": "Ovos", "quantity_in_stock": 2, "unity": "unidades", "slug": "ovos"},
                {"id": 12, "name": "Frango", "quantity_in_stock": 0.5, "unity": "kg", "slug": "frango"}]', 'torta-de-frango'),

             ( 'Sopa de Legumes', 'Sopa quente de legumes variados', 15.00,
              JSON '[{"id": 18, "name": "Cenouras", "quantity_in_stock": 0.2, "unity": "kg", "slug": "cenouras"},
                {"id": 18, "name": "Tomates", "quantity_in_stock": 0.15, "unity": "kg", "slug": "tomates"},
                {"id": 18, "name": "Espinafre", "quantity_in_stock": 0.1, "unity": "kg", "slug": "espinafre"},
                {"id": 1, "name": "Farinha", "quantity_in_stock": 0.05, "unity": "kg", "slug": "farinha"}]', 'sopa-de-legumes'),

             ( 'Arroz à Grega', 'Arroz com legumes e temperos', 20.00,
              JSON '[{"id": 18, "name": "Arroz", "quantity_in_stock": 0.2, "unity": "kg", "slug": "arroz"},
                {"id": 18, "name": "Milho", "quantity_in_stock": 0.1, "unity": "kg", "slug": "milho"},
                {"id": 18, "name": "Ervilhas", "quantity_in_stock": 0.1, "unity": "kg", "slug": "ervilhas"},
                {"id": 18, "name": "Pimenta-do-Reino", "quantity_in_stock": 0.01, "unity": "kg", "slug": "pimenta-do-reino"}]', 'arroz-a-grega'),

             ( 'Feijão Tropeiro', 'Feijão com farofa e temperos', 18.00,
              JSON '[{"id": 18, "name": "Feijão Preto", "quantity_in_stock": 0.2, "unity": "kg", "slug": "feijao-preto"},
                {"id": 18, "name": "Farinha de Mandioca", "quantity_in_stock": 0.1, "unity": "kg", "slug": "farinha-de-mandioca"},
                {"id": 18, "name": "Cebola", "quantity_in_stock": 0.05, "unity": "kg", "slug": "cebola"},
                {"id": 18, "name": "Bacon", "quantity_in_stock": 0.05, "unity": "kg", "slug": "bacon"}]', 'feijao-tropeiro'),

             ( 'Quibe Assado', 'Quibe recheado e assado no forno', 30.00,
              JSON '[{"id": 18, "name": "Trigo", "quantity_in_stock": 0.3, "unity": "kg", "slug": "trigo"},
                {"id": 18, "name": "Carne Bovina", "quantity_in_stock": 0.25, "unity": "kg", "slug": "carne-bovina"},
                {"id": 18, "name": "Cebola", "quantity_in_stock": 0.05, "unity": "kg", "slug": "cebola"},
                {"id": 18, "name": "Pimenta-do-Reino", "quantity_in_stock": 0.01, "unity": "kg", "slug": "pimenta-do-reino"}]', 'quibe-assado');


