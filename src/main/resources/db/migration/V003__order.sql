CREATE SEQUENCE public.order_id_seq;

CREATE TABLE public.order
(
    id integer PRIMARY KEY DEFAULT nextval('public.order_id_seq'),
    created_at TIMESTAMP WITH TIME ZONE,
    is_prize BOOLEAN
);

ALTER SEQUENCE public.order_id_seq OWNED BY public.order.id;

