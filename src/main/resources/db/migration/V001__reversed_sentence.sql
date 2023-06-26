CREATE SEQUENCE public.reversed_sentence_id_seq;

CREATE TABLE public.reversed_sentence (
    id BIGINT PRIMARY KEY DEFAULT nextval('public.reversed_sentence_id_seq'),
    original_sentence TEXT,
    reversed_sentence TEXT
);

ALTER SEQUENCE public.reversed_sentence_id_seq OWNED BY public.reversed_sentence.id;
