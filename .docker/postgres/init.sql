CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS public.covers;
CREATE TABLE public.covers(
    id UUID DEFAULT uuid_generate_v4(),
    small VARCHAR(255),
    medium VARCHAR(255),
    large VARCHAR(255),

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.books;
CREATE TABLE public.books(
    id UUID DEFAULT uuid_generate_v4(),
    title VARCHAR(100) NOT NULL,
    subtitle VARCHAR(100) NOT NULL,
    url VARCHAR(255) NOT NULL,
    number_of_pages INTEGER NOT NULL,
    pagination VARCHAR(30) NOT NULL,
    by_statement VARCHAR(30) NOT NULL,
    publish_date DATE NOT NULL,
    notes VARCHAR(255),
    cover_id UUID NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (cover_id) REFERENCES covers (id)
);

DROP TABLE IF EXISTS public.authors;
CREATE TABLE public.authors(
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(60) NOT NULL,
    url VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.book_authors;
CREATE TABLE public.book_authors(
    book_id UUID NOT NULL,
    author_id UUID NOT NULL,

    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors (id) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS public.identifiers;
CREATE TABLE public.identifiers(
    id UUID DEFAULT uuid_generate_v4(),
    type VARCHAR(20) NOT NULL,
    number VARCHAR(60) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.book_identifiers;
CREATE TABLE public.book_identifiers(
    book_id UUID NOT NULL,
    identifier_id UUID NOT NULL,

    PRIMARY KEY (book_id, identifier_id),
    FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE,
    FOREIGN KEY (identifier_id) REFERENCES identifiers (id) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS public.publishers;
CREATE TABLE public.publishers(
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(60) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.book_publishers;
CREATE TABLE public.book_publishers(
    book_id UUID NOT NULL,
    publisher_id UUID NOT NULL,

    PRIMARY KEY (book_id, publisher_id),
    FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE,
    FOREIGN KEY (publisher_id) REFERENCES publishers (id) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS public.publish_places;
CREATE TABLE public.publish_places(
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(60) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.book_publish_places;
CREATE TABLE public.book_publish_places(
    book_id UUID NOT NULL,
    publish_place_id UUID NOT NULL,

    PRIMARY KEY (book_id, publish_place_id),
    FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE,
    FOREIGN KEY (publish_place_id) REFERENCES publish_places (id) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS public.subjects;
CREATE TABLE public.subjects(
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(60) NOT NULL,
    url VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.book_subjects;
CREATE TABLE public.book_subjects(
    book_id UUID NOT NULL,
    subject_id UUID NOT NULL,

    PRIMARY KEY (book_id, subject_id),
    FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subjects (id) ON UPDATE CASCADE
);

INSERT INTO public.covers (id, small, medium, large) VALUES (
    '0402d2b9-0c2b-435e-9190-a789e0308685',
    'https://covers.openlibrary.org/b/id/11311437-S.jpg',
    'https://covers.openlibrary.org/b/id/11311437-M.jpg',
    'https://covers.openlibrary.org/b/id/11311437-L.jpg'
);

INSERT INTO public.books (
    id,
    title,
    subtitle,
    url,
    number_of_pages,
    pagination,
    by_statement,
    publish_date,
    notes,
    cover_id
) VALUES (
    '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
    'The clean coder',
    'a code of conduct for professional programmers',
    'https://openlibrary.org/books/OL25108903M/The_clean_coder',
    210,
    'xxxii, 210 p. :',
    'Robert Martin',
    '2011-05-23',
    'Includes  index.',
    '0402d2b9-0c2b-435e-9190-a789e0308685'
);

INSERT INTO public.authors (id, name, url) VALUES (
    '294e58c5-edbf-4068-86c6-ffa7a525f1c3',
    'Robert C. Martin',
    'https://openlibrary.org/authors/OL2653686A/Robert_C._Martin'
);

INSERT INTO public.book_authors (book_id, author_id) VALUES (
    '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
    '294e58c5-edbf-4068-86c6-ffa7a525f1c3'
);

INSERT INTO public.identifiers (id, type, number) VALUES
    ('eef60ff3-703d-4e39-9a3b-65c4af55609d', 'isbn_10', '0137081073'),
    ('c1e6bd53-d8f9-4cfc-99d7-b74d1bbf14bb', 'isbn_13', '9780137081073'),
    ('55bf3f0f-d693-48bd-b564-fc467605c2e5', 'lccn', '2011005962'),
    ('bb730289-9b38-4a5e-8e0d-b5d65185b22c', 'openlibrary', 'OL25108903M');

INSERT INTO public.book_identifiers (book_id, identifier_id) VALUES
    (
        '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
        'eef60ff3-703d-4e39-9a3b-65c4af55609d'
    ),
    (
        '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
        'c1e6bd53-d8f9-4cfc-99d7-b74d1bbf14bb'
    ),
    (
        '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
        '55bf3f0f-d693-48bd-b564-fc467605c2e5'
    ),
    (
        '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
        'bb730289-9b38-4a5e-8e0d-b5d65185b22c'
    );

INSERT INTO public.publishers (id, name) VALUES (
    '74ab0ddd-a19b-497e-920c-39158ae3915f',
    'Prentice Hall'
);

INSERT INTO public.book_publishers (book_id, publisher_id) VALUES (
    '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
    '74ab0ddd-a19b-497e-920c-39158ae3915f'
);

INSERT INTO public.publish_places (id, name) VALUES (
    '6fbfcd97-ebb0-4a75-947a-b772aa139869',
    'Upper Saddle River, NJ'
);

INSERT INTO public.book_publish_places (book_id, publish_place_id) VALUES (
    '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
    '6fbfcd97-ebb0-4a75-947a-b772aa139869'
);

INSERT INTO public.subjects (id, name, url) VALUES
    (
        '421f4e1a-af8b-4511-b836-b5ffba2785d5',
        'Computer programmers',
        'https://openlibrary.org/subjects/computer_programmers'
    ),
    (
        'f264efe7-1ff3-40ee-80e6-6461af7048e7',
        'Computer programming',
        'https://openlibrary.org/subjects/computer_programming'
    ),
    (
        '8bce1ff7-a550-4a76-9d2b-78bad2fc82a7',
        'Moral and ethical aspects',
        'https://openlibrary.org/subjects/moral_and_ethical_aspects'
    ),
    (
        'e57f7dd6-0b2a-460b-9e17-be0f9c8fe8cd',
        'Professional ethics',
        'https://openlibrary.org/subjects/professional_ethics'
    );

INSERT INTO public.book_subjects (book_id, subject_id) VALUES
    (
         '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
         '421f4e1a-af8b-4511-b836-b5ffba2785d5'
    ),
    (
         '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
         'f264efe7-1ff3-40ee-80e6-6461af7048e7'
    ),
    (
         '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
         '8bce1ff7-a550-4a76-9d2b-78bad2fc82a7'
    ),
    (
         '73fd2dc7-581a-4580-9ed8-453c54d8b0cd',
         'e57f7dd6-0b2a-460b-9e17-be0f9c8fe8cd'
    );