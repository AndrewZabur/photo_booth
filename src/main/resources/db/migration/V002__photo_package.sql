CREATE SEQUENCE public.photo_package_type_id_seq;

CREATE TABLE public.photo_package_type
(
    id integer PRIMARY KEY DEFAULT nextval('public.photo_package_type_id_seq'),
    price DECIMAL(10, 2),
    dimension TEXT,
    photo_type VARCHAR(255) UNIQUE,
    CONSTRAINT photo_type_check CHECK(photo_type IN ('PRINTS', 'PANORAMAS', 'STRIPS'))
);

ALTER SEQUENCE public.photo_package_type_id_seq OWNED BY public.photo_package_type.id;

INSERT INTO public.photo_package_type (id, price, dimension, photo_type)
VALUES
    (1, 5.00, '4x6', 'PRINTS'),
    (2, 7.00, '6x12', 'PANORAMAS'),
    (3, 5.00, '2x6', 'STRIPS');

SELECT setval('public.photo_package_type_id_seq', (SELECT MAX(id) FROM public.photo_package_type));