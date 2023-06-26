CREATE SEQUENCE public.tax_id_seq;

CREATE TABLE public.tax (
    id BIGINT PRIMARY KEY DEFAULT nextval('public.tax_id_seq'),
    month TEXT,
    year INTEGER,
    tax_percent DOUBLE PRECISION,
    quantity_of_sold_packages BIGINT,
    total_income NUMERIC(19, 2),
    tax NUMERIC(19, 2)
);

ALTER SEQUENCE public.tax_id_seq OWNED BY public.tax.id;
