CREATE FUNCTION GetAge(@dob DATE)
RETURNS INT
AS
BEGIN
    -- Calculate age based on the date of birth and the current date
    DECLARE @age INT;
    SET @age = DATEDIFF(year, @dob, GETDATE());

    -- Adjust for cases where this year's birthday has not yet occurred
    IF (MONTH(@dob) > MONTH(GETDATE())) OR (MONTH(@dob) = MONTH(GETDATE()) AND DAY(@dob) > DAY(GETDATE()))
        SET @age = @age - 1;

    RETURN @age;
END;
GO

CREATE FUNCTION CalculateConsultationFee
(
    @CitizenCardNumber VARCHAR(255),
    @Specialization VARCHAR(255)
)
RETURNS DECIMAL(10,2)
AS
BEGIN
    DECLARE @BaseCost DECIMAL(10,2);
    DECLARE @DiscountFactor DECIMAL(10,2) = 0.60;  -- 40% discount, so pay 60%
    DECLARE @TotalCost DECIMAL(10,2);
    DECLARE @HasInsurance BIT;

    -- Determine if the patient has insurance
    SET @HasInsurance = dbo.CheckPatientInsurance(@CitizenCardNumber);

    -- Get base cost for the specialization
    SELECT @BaseCost = ConsultationCost
    FROM Specializations
    WHERE SpecializationID = @Specialization;

    -- Handle the case where no cost is found for the specialization
    IF @BaseCost IS NULL
        SET @BaseCost = 0;  -- Consider setting a default cost or handling this with an error

    -- Calculate total cost based on insurance
    IF @HasInsurance = 1
        SET @TotalCost = @BaseCost * @DiscountFactor;
    ELSE
        SET @TotalCost = @BaseCost;

    RETURN @TotalCost;
END;
GO

CREATE FUNCTION CheckPatientInsurance
(
    @CitizenCardNumber VARCHAR(255)
)
RETURNS BIT
AS
BEGIN
    DECLARE @HasInsurance BIT;

    -- Get insurance status directly from the Insurance column
    SELECT @HasInsurance = Insurance
    FROM Patient
    WHERE CitizenCardNumber = @CitizenCardNumber;

    -- Handle case where no such patient exists
    IF @HasInsurance IS NULL
        SET @HasInsurance = 0;

    RETURN @HasInsurance;
END;
GO