UPDATE tag
    SET tag_name = CASE id
        WHEN 1 THEN 'melbourne'
        WHEN 2 THEN 'sydney'
        WHEN 3 THEN 'fiction'
        WHEN 4 THEN 'comedy'
        WHEN 5 THEN 'avenger'
        WHEN 6 THEN 'starcraft'
    END