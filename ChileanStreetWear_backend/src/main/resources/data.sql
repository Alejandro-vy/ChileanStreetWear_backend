-- ====================
-- Categorías
-- ====================
INSERT INTO category (id, name) VALUES
                                    ('11111111-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Poleras'),
                                    ('11111111-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Polerones'),
                                    ('11111111-cccc-cccc-cccc-cccccccccccc', 'Pantalones'),
                                    ('11111111-dddd-dddd-dddd-dddddddddddd', 'Jockeys'),
                                    ('11111111-eeee-eeee-eeee-eeeeeeeeeeee', 'Accesorios');

-- ====================
-- Marcas
-- ====================
INSERT INTO brand (id, name, logo_url, website_url, description, created_at, updated_at) VALUES
                                                                                             ('22222222-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Marca Andes', 'https://logo.com/andes.png', 'https://andeswear.cl', 'Marca inspirada en la cordillera y el diseño andino.', now(), now()),
                                                                                             ('22222222-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Santiago Hype', 'https://logo.com/hype.png', 'https://santiagohype.cl', 'Urbana y disruptiva desde el centro de Santiago.', now(), now()),
                                                                                             ('22222222-cccc-cccc-cccc-cccccccccccc', 'Norte Calle', 'https://logo.com/nortecalle.png', 'https://nortecalle.cl', 'Desde Arica con estilo callejero y tropical.', now(), now()),
                                                                                             ('22222222-dddd-dddd-dddd-dddddddddddd', 'Rude Style', 'https://logo.com/rude.png', 'https://rudestyle.cl', 'Ropa agresiva con mensaje social fuerte.', now(), now()),
                                                                                             ('22222222-eeee-eeee-eeee-eeeeeeeeeeee', 'SurReal', 'https://logo.com/surreal.png', 'https://surreal.cl', 'Minimalismo y surrealismo desde el sur.', now(), now()),
                                                                                             ('22222222-ffff-ffff-ffff-ffffffffffff', 'Valpo Street', 'https://logo.com/valpo.png', 'https://valpostreet.cl', 'Arte callejero y bohemia en cada prenda.', now(), now());

-- ====================
-- Relaciones Marca–Categoría
-- ====================
INSERT INTO brand_category (brand_id, category_id) VALUES
                                                       -- Marca Andes
                                                       ('22222222-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-aaaa-aaaa-aaaa-aaaaaaaaaaaa'), -- Poleras
                                                       ('22222222-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-bbbb-bbbb-bbbb-bbbbbbbbbbbb'), -- Polerones

                                                       -- Santiago Hype
                                                       ('22222222-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '11111111-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
                                                       ('22222222-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '11111111-cccc-cccc-cccc-cccccccccccc'),

                                                       -- Norte Calle
                                                       ('22222222-cccc-cccc-cccc-cccccccccccc', '11111111-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
                                                       ('22222222-cccc-cccc-cccc-cccccccccccc', '11111111-dddd-dddd-dddd-dddddddddddd'),

                                                       -- Rude Style
                                                       ('22222222-dddd-dddd-dddd-dddddddddddd', '11111111-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
                                                       ('22222222-dddd-dddd-dddd-dddddddddddd', '11111111-cccc-cccc-cccc-cccccccccccc'),

                                                       -- SurReal
                                                       ('22222222-eeee-eeee-eeee-eeeeeeeeeeee', '11111111-eeee-eeee-eeee-eeeeeeeeeeee'),

                                                       -- Valpo Street
                                                       ('22222222-ffff-ffff-ffff-ffffffffffff', '11111111-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
                                                       ('22222222-ffff-ffff-ffff-ffffffffffff', '11111111-dddd-dddd-dddd-dddddddddddd'),
                                                       ('22222222-ffff-ffff-ffff-ffffffffffff', '11111111-eeee-eeee-eeee-eeeeeeeeeeee');
