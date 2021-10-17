create schema if not exists diamond;

create table diamond.users
(
    id                  varchar(43) primary key,
    name                varchar(32),
    country             varchar(32),
    city                varchar(32),
    email               varchar(100),
    wardrobe_efficiency float,
    avatar_path         varchar(256),
    fitted_outfit       jsonb
);

create table diamond.sections
(
    id          integer primary key,
    code        varchar(8)  not null,
    description varchar(64) not null
);

create table diamond.categories
(
    id          integer primary key,
    code        varchar(8)  not null,
    description varchar(64) not null,
    section_id  integer     not null,
    foreign key (section_id) references diamond.sections (id) on delete cascade
);

create table diamond.colors
(
    id          integer primary key,
    code        varchar(8)  not null,
    description varchar(64) not null
);


create table diamond.prints
(
    id          integer primary key,
    code        varchar(8)  not null,
    description varchar(64) not null
);


create table diamond.clothes
(
    uuid        uuid primary key,
    user_id     varchar(16)  not null,
    img_path    varchar(256) not null,
    category_id integer,
    color_id    integer,
    print_id    integer,
    foreign key (user_id) references diamond.users (id) on delete cascade,
    foreign key (category_id) references diamond.categories (id) on delete cascade,
    foreign key (color_id) references diamond.colors (id) on delete cascade,
    foreign key (print_id) references diamond.prints (id) on delete cascade
);

create table diamond.stories
(
    uuid             uuid primary key,
    preview_img_path varchar(256),
    img_path         varchar(256),
    caption          varchar(1000),
    title            varchar(256),
    subtitle         varchar(256)
);

create table diamond.users_stories
(
    user_id    varchar(16),
    story_uuid uuid not null,
    was_seen   bool not null,
    foreign key (user_id) references diamond.users (id) on delete cascade,
    foreign key (story_uuid) references diamond.stories (uuid) on delete cascade
);