SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE ID IN (
    SELECT ID
    FROM DEVELOPERS, SKILLCODES
    WHERE (NAME = 'Python'
    OR NAME = 'C#')
    AND SKILL_CODE & CODE > 0
)
ORDER BY ID ASC;