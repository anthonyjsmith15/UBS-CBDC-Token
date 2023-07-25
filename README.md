# UBS-CBDC-Token

**Introduction**

The case for Universal Basic Services is now unquestionable. We face a perilous time of rising energy prices,
the threat of another Great Recession having inflated asset prices to recover from the very recent last one that
served only to increase global inequality and perhaps even deflation or stagflation should inappropriate
interventionist action be taken. Let alone the very real danger of being dragged into another war along with
Europe.
These factors have served to ravage the disposable income available to the average household through
exorbitant energy bills and rising food inflation. However, the advent of Central Bank Digital Currencies
(CBDCs) paves the way forward for a new era of UBS tokens that are linked to CBDCs that can relieve the
financial pressures every citizen faces now and for the foreseeable future.
The difference between current paper fiat currency and CBDC is that a CBDC will permit the creation of tokens
that are intrinsically linked to the CBDC through an exchange rate mechanism which are capable of having
their supply increased or decreased. It is illegal to burn supply currently – tokens, however, can be as they are
not fiat.
This ability to burn the supply of tokens permits a new era of inflation management whereby supply can be
controlled in both directions, should inflation be above or below the Central Bank target. A new weapon is at
their disposal. Currently, inflation is the equivalent of burning fiat supply to reduce value and encourage
growth at all times. But by tempering the rate of inflation with token burning, Central Bank inflation targets
could actually be reduced over time.

**Usage**

Create a postgres database called deflationtoken and add the tables as displayed in 'tablesSQL'. You will need the secretkey and secretphrase fields populated in the 'secret' table for the calculations to be processed. Please message me at antjsmith@protonmail.com if you wish to acquire them.

Running the BoEBlockhain Java app will run UKTCTInitial, which in turn runs UKTCTv2 using CLI arguments 'uktctinitial uktctv2'.

You will see the modelling in the console running for a two year period based on historical inflation rates which calculates the volume of tokens to be burnt or minted each month to maintain a fixed supply of the UK Digital Pound. Also displayed is the token to CBDC exchange rate and token supply, along with sample token quotas given to a 50 year old citizen and an 18 year old. 
