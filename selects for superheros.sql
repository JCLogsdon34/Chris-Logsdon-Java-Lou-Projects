USE Superheros;

select L.LikesID, L.PostID, L.Likes
from Likes L
inner join Post P on L.PostID = P.PostID;


select H.HashTagID, Name
from HashTag H
inner join Post P on H.HashTagID = P.PostID;



INSERT INTO superhero_superpower (superHeroID, superPowerID)
VALUES (1, 1);

select Author.AuthorID, Author.Name 
from Author 
inner join Post_Author on Author.AuthorID = Post_Author.authorID 
INNER JOIN  Post ON Post_Author.PostID = Post.PostID 
where Post.PostID = 1;

select Post.PostID, Post.Title, Post.Text, Post.PostDate 
from Post 
inner join Post_Author on Post.PostID = Post_Author.PostID 
INNER JOIN  Author ON Post_Author.AuthorID = Author.AuthorID 
where Author.AuthorID = 1;


-- hashtag by post id
select *
from HashTag h
inner join HashTag_Post on h.HashTagID = HashTag_Post.HashTagID
inner join HashTag on HashTag_Post.PostID = Post.PostID
where Post.PostID = 1;


select *
from HashTag_Post htp
inner join HashTag h on htp.HashTagID = h.HashTagID
inner join Post p on htp.PostID = p.PostID
where h.HashTagID = 1;

-- get post by hash tag ID
select p.PostID, p.Title, p.Text, p.PostDate
from HashTag_Post htp
inner join HashTag h on htp.HashTagID = h.HashTagID
inner join Post p on htp.PostID = p.PostID
where h.HashTagID = 1;

select *
from superhero_has_sighting
inner join Heros h on superhero_has_sighting.superHeroID = h.superHeroID
inner join Sighting s on superhero_has_sighting.sightingID = s.sightingID
where h.superHeroID = 1;

-- get post by author ID
select p.PostID, p.Title, p.Text, p.PostDate
from Post_Author pa
inner join Author a on pa.AuthorID = a.AuthorID
inner join Post p on pa.PostID = p.PostID
where a.AuthorID = 6;



-- get post by category ID
select p.PostID, p.Title, p.Text, p.PostDate
from Post_Category pc
inner join Category c on pc.CategoryID = c.CategoryID
inner join Post p on pc.PostID = p.PostID
where c.CategoryID = 1;

-- get post by Post Status ID
select p.PostID, p.Title, p.Text, p.PostDate
from Post_PostStatus pps
inner join PostStatus ps on pps.PostStatusID = ps.PostStatusID
inner join Post p on pps.PostID = p.PostID
where ps.PostStatusID = 1;

-- get hashtag by post ID
select h.HashTagID, h.Name
from HashTag_Post htp
inner join HashTag h on htp.HashTagID = h.HashTagID
inner join Post p on htp.PostID = p.PostID
where p.PostID = 1;


-- get category by post ID
-- or in this case, org by heroID
select *
from superhero_organization so
inner join Heros s on so.superHeroID = s.superHeroID
inner join Organizations o on so.orgID = so.orgID
WHERE o.orgID = 1 ;

-- get post status by post ID
select ps.PostStatusID, ps.Description
from Post_PostStatus pps
inner join Post p on pps.PostID = p.PostID
inner join PostStatus ps on pps.PostStatusID = ps.PostStatusID
where p.PostID = 1;

insert into superhero_organization (superHeroID, orgID) values(1, 1);

delete from superhero_organization where superHeroID = 1;
