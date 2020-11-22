% John Luke Denny
% CSC 2262
% cs226224
% Lab 9b

%Reads a data file and calculates the first, second, third, and fourth
%derivative of a polyunomial

[xd, yd] = textread('Lab9a.dat');

n = length(xd);

for(k = 7 : n-7)
    
xd7=[xd(k-3) xd(k-2) xd(k-1) xd(k) xd(k+1) xd(k+2) xd(k+3)];
yd7=[yd(k-3) yd(k-2) yd(k-1) yd(k) yd(k+1) yd(k+2) yd(k+3)];

xd9 = [ xd(k-4) xd(k-3) xd(k-2) xd(k-1) xd(k) xd(k+1) xd(k+2) xd(k+3) xd(k+4)];
yd9 = [ yd(k-4) yd(k-3) yd(k-2) yd(k-1) yd(k) yd(k+1) yd(k+2) yd(k+3) yd(k+4)];

xd11 = [ xd(k-5) xd(k-4) xd(k-3) xd(k-2) xd(k-1) xd(k) xd(k+1) xd(k+2) xd(k+3) xd(k+4) xd(k+5)];
yd11 = [ yd(k-5) yd(k-4) yd(k-3) yd(k-2) yd(k-1) yd(k) yd(k+1) yd(k+2) yd(k+3) yd(k+4) yd(k+5)];

xd13 = [ xd(k-6) xd(k-5) xd(k-4) xd(k-3) xd(k-2) xd(k-1) xd(k) xd(k+1) xd(k+2) xd(k+3) xd(k+4) xd(k+5) xd(k+6)];
yd13 = [ yd(k-6) yd(k-5) yd(k-4) yd(k-3) yd(k-2) yd(k-1) yd(k) yd(k+1) yd(k+2) yd(k+3) yd(k+4) yd(k+5) yd(k+6)];

c6 = polyfit( xd7, yd7, 6 );
c8 = polyfit( xd9, yd9, 8 );
c10 = polyfit( xd11, yd11, 10 );
c12 = polyfit( xd13, yd13, 12 );

cder6 = polyder(c6);
der6 = polyval( cder6, xd(k) );

csecder6 = polyder(cder6);
secder6 = polyval( csecder6, xd(k) );

cthirdder6 = polyder(csecder6);
thirdder6 = polyval( cthirdder6, xd(k) );

cfourthder6 = polyder(cthirdder6);
fourthder6 = polyval( cfourthder6, xd(k) );

cder8 = polyder(c8);
der8 = polyval( cder8, xd(k) );

csecder8 = polyder(cder8);
secder8 = polyval( csecder8, xd(k) );

cthirdder8 = polyder(csecder8);
thirdder8 = polyval( cthirdder8, xd(k) );

cfourthder8 = polyder(cthirdder8);
fourthder8 = polyval( cfourthder8, xd(k) );

cder10 = polyder(c10);
der10 = polyval( cder10, xd(k) );

csecder10 = polyder(cder10);
secder10 = polyval( csecder10, xd(k) );

cthirdder10 = polyder(csecder10);
thirdder10 = polyval( cthirdder10, xd(k) );

cfourthder10 = polyder(cthirdder10);
fourthder10 = polyval( cfourthder10, xd(k) );

cder12 = polyder(c12);
der12 = polyval( cder12, xd(k) );

csecder12 = polyder(cder12);
secder12 = polyval( csecder12, xd(k) );

cthirdder12 = polyder(csecder12);
thirdder12 = polyval( cthirdder12, xd(k) );

cfourthder12 = polyder(cthirdder12);
fourthder12 = polyval( cfourthder12, xd(k) );

fprintf('x = %.1f der6 = %.3f der8 = %.3f der10 = %.3f der12 = %.3f\n',xd(k), der6, der8, der10, der12);
fprintf('x = %.1f secder6 = %.3f secder8 = %.3f secder10 = %.3f secder12 = %.3f\n',xd(k), secder6, secder8, secder10, secder12);
fprintf('x = %.1f thirdder6 = %.3f thirdder8 = %.3f thirdder10 = %.3f thirdder12 = %.3f\n',xd(k), thirdder6, thirdder8, thirdder10, thirdder12);
fprintf('x = %.1f fourthder6 = %.3f fourthder8 = %.3f fourthder10 = %.3f fourthder12 = %.3f\n\n',xd(k), fourthder6, fourthder8, fourthder10, fourthder12);

end