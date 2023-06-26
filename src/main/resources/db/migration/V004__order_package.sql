CREATE SEQUENCE public.order_package_id_seq;

CREATE TABLE public.order_package
(
    id bigint PRIMARY KEY DEFAULT nextval('public.order_package_id_seq'),
    order_id bigint NOT NULL,
    photo_package_id bigint NOT NULL,
    order_package_type VARCHAR(255),
    FOREIGN KEY (order_id) REFERENCES public.order(id),
    FOREIGN KEY (photo_package_id) REFERENCES public.photo_package_type(id)
);

ALTER SEQUENCE public.order_package_id_seq OWNED BY public.order_package.id;
